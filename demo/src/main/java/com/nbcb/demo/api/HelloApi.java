package com.nbcb.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author 任侃-141398
 * 2019/3/14 14:33
 */
@RestController
public class HelloApi {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World !";
    }
}
