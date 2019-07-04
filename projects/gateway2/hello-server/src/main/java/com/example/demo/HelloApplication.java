package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class HelloApplication {

    @Value("${test.name:123}")
    private String name;

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        return "hello "+ name;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
