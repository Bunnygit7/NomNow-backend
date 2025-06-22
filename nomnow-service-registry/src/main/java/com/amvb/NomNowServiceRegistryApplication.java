package com.amvb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NomNowServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NomNowServiceRegistryApplication.class, args);
	}

}
