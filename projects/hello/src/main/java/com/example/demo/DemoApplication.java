package com.example.demo;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		try {
			File file = ResourceUtils.getFile("classpath:a.txt");
			String  s = IOUtils.toString(new FileInputStream(file),"utf-8");
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
