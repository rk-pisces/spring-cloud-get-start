package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "USER-SERVER", fallback = UserServerFallback.class)
public interface UserFeignClient {

    @GetMapping("/users")
    public List<User> getUsers();

}
