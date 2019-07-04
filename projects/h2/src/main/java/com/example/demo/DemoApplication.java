package com.example.demo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class DemoApplication {

	@Value("${test.timeout:200}")
	private int timeout;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Config config = ConfigService.getAppConfig();
		int timeout = config.getIntProperty("test.timeout",200);
	}

}
