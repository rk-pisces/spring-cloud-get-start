package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class GatewayPathApplication {

	@Bean
	public RouteLocator pathRouteLocator(RouteLocatorBuilder builder){
		return builder.routes().route(
				r->r.path("/hello").uri("http://localhost:9080").id("hello_route")
		).build();
	}

	//@Bean
	public RouteLocator beforeRouteLocator(RouteLocatorBuilder builder){
		ZonedDateTime dateTime = LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault());
		return builder.routes().route(
				r -> r.before(dateTime).uri("http://localhost:9080").id("hello_route")
		).build();
	}

	//@Bean
	public RouteLocator addRequestHeaderRouteLocator(RouteLocatorBuilder builder){
		return builder.routes().route(
				r->r.path("/hello")
						.filters(f -> f.addRequestHeader("test","123"))
						.uri("http://localhost:9080").id("hello_route")
		).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayPathApplication.class, args);
	}

}
