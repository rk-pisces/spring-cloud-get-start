package com.nbcb.demo;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ribbonfilter 根据request头中env的值进行路由
 * @author 任侃-141398
 */
public class EnvInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RibbonFilterContextHolder.clearCurrentContext();
        String env = request.getHeader("env");
        if (null == env || env.isEmpty()) {
            RibbonFilterContextHolder.getCurrentContext().add("env", "v1");
        } else {
            RibbonFilterContextHolder.getCurrentContext().add("env", env);
        }
        return true;
    }
}
