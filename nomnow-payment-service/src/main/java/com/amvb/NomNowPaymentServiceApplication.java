package com.amvb;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NomNowPaymentServiceApplication {


	public static void main(String[] args) {

// 		Dotenv dotenv = Dotenv.configure()
// 				.directory("D:/Swiggy/Backend/nomnow-payment-service") // This points to the project root
// 				.filename(".env")
// 				.load();

// // Set env vars for Spring to use
// 		System.setProperty("RAZORPAY_TEST_KEY", dotenv.get("RAZORPAY_TEST_KEY"));
// 		System.setProperty("RAZORPAY_TEST_SECRET", dotenv.get("RAZORPAY_TEST_SECRET"));

		SpringApplication.run(NomNowPaymentServiceApplication.class, args);
	}

}
