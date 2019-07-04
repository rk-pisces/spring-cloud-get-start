package com.example.demo;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class DemoService {

    public Boolean tryIt() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String retCode = (String) request.getAttribute("retCode");
        if (null != retCode && retCode.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean tryIt(HttpServletRequest request) {
        String retCode = (String) request.getAttribute("retCode");
        if (null != retCode && retCode.equals("0")) {
            return true;
        } else {
            return false;
        }
    }
}
