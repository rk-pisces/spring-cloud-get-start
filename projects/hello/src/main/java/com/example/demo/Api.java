package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    @Value("${a.b.c:true}")
    private Boolean flag;

    @GetMapping("/hello")
    public String hello() {
        System.out.println(flag);
        return "Hello World !";
    }

}
