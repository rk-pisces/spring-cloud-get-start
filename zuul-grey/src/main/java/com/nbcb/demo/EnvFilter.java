package com.nbcb.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Configuration
@Slf4j
public class EnvFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String env = request.getHeader("env");
        log.info("customer visit with env = {}", env);
        if (null == env || env.isEmpty()) {
            RibbonFilterContextHolder.getCurrentContext().add("env", "v1");
        } else {
            RibbonFilterContextHolder.getCurrentContext().add("env", env);
        }
        return null;
    }
}
