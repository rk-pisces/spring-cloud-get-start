package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class UserService {
    public List<User> getUsers() {
        return Arrays.asList(
                new User(1L, "赵", "133", "鄞州"),
                new User(2L, "钱", "134", "北仑"),
                new User(3L, "孙", "135", "江北")
        );
    }

    public User getUser(Long id) {
        if (1L == id) {
            return new User(1L, "赵", "133", "鄞州");
        } else {
            return null;
        }
    }

    public List<User> getUserByPhoneNo(String phone) {
        if ("133".equals(phone)) {
            return Arrays.asList(new User(1L, "赵", "133", "鄞州"));
        } else {
            return null;
        }
    }

    public void create(User user) {
        log.info("==== create user:{} ====", user);
    }

    public void delete(Long id) {
        log.info("==== delete user:{} ====", id);
    }

    public void update(User user) {
        log.info("==== update user:{} ====", user);
    }
}
