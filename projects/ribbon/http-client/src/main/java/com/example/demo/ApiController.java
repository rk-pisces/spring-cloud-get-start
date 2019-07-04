package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class ApiController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/api/users")
    public List<User> testGetUsers() {
        List<User> users = (List<User>) restTemplate.getForObject("http://USER-SERVER/users", List.class);
        //List<User> users = restTemplate.exchange("http://USER-SERVER/users", HttpMethod.GET, null, List.class).getBody();
        log.info("==== users:{} ====", users);
        return users;
    }

    @Autowired
    UserFeignClient feignClient;

    @GetMapping("/api/users2")
    public List<User> testGetUsers2() {
        List<User> users = feignClient.getUsers();
        log.info("==== users:{} ====", users);
        return users;
    }

    @GetMapping("/api/hello")
    public String testHello() {
        String s = feignClient.hello();
        log.info("==== {} ====",s);
        return s;
    }
}
