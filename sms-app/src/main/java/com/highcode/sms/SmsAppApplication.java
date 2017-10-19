package com.highcode.sms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.highcode.sms.fileupload.StorageProperties;
import com.highcode.sms.fileupload.StorageService;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EntityScan("com.highcode.sms.model")
@EnableAutoConfiguration
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class SmsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsAppApplication.class, args);
	}
	
	  @Bean
	    CommandLineRunner init(StorageService storageService) {
	        return (args) -> {
	            storageService.init();
	        };
	    }
	
}
