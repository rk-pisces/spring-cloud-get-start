package com.nbcb.demo;

import org.springframework.stereotype.Component;

/**
 * .
 *
 * @author 任侃-141398
 * 2019/3/16 17:06
 */
@Component
public class FeignServerFallback implements FeignServer {
    @Override
    public String hello() {
        return "feign-server no answer";
    }
}
