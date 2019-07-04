package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class GatewayFilterApplication {

	@Bean
	public RouteLocator pathRouteLocator(RouteLocatorBuilder builder){
		return builder.routes().route(
				r->r.path("/hello")
						.filters(f -> f.filter(new CustomGatewayFilter()))
						.uri("http://localhost:9080")
						.id("hello")
		).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayFilterApplication.class, args);
	}

}
