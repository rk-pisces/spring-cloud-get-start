package com.nbcb.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * .
 *
 * @author 任侃-141398
 * 2019/3/16 15:45
 */
@FeignClient(name = "feign-server", fallback = FeignServerFallback.class)
public interface FeignServer {

    @GetMapping("/hello")
    public String hello();
}