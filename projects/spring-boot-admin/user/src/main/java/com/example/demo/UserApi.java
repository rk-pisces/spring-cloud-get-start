package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(@Nullable @RequestParam("phone") String phone) {
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
