package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserServerFallback implements UserFeignClient {

    @Override
    public List<User> getUsers() {
        log.warn("==== fallback worked ====");
        return null;
    }

}
