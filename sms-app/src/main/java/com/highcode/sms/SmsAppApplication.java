package com.highcode.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EntityScan("com.highcode.sms.model")
@EnableAutoConfiguration
@Configuration
public class SmsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsAppApplication.class, args);
	}
	
	
}
