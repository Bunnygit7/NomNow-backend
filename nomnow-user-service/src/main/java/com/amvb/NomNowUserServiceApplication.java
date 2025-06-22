package com.amvb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NomNowUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NomNowUserServiceApplication.class, args);
	}

}
