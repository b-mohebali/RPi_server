package com.example.gpio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class GpioControlApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GpioControlApplication.class, args);
	}
}
