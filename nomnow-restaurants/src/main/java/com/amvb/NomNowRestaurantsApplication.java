package com.amvb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NomNowRestaurantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NomNowRestaurantsApplication.class, args);
	}

}
