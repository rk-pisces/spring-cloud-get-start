package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(@Nullable @RequestParam("phone") String phone) throws InterruptedException {
        log.info("==== excute get users ====");
        int time = (int)(Math.random() * 7000);
        Thread.sleep(time);
        if (null == phone || phone.isEmpty()) {
            return userService.getUsers();
        } else {
            return userService.getUserByPhoneNo(phone);
        }
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PatchMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }
}
