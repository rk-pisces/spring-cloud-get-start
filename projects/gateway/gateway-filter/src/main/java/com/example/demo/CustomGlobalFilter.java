package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("startTime2",System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    long startTime = exchange.getAttribute("startTime2");
                    long cost = System.currentTimeMillis() - startTime;
                    log.info("==== CustomGlobalFilter: {} cost {} ms ====",exchange.getRequest().getURI().getRawPath(),cost);
                })
        );
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE+2;
    }
}
