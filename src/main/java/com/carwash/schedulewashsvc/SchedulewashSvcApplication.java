package com.carwash.schedulewashsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SchedulewashSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulewashSvcApplication.class, args);
	}

}
