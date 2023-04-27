package com.joseparra.qualificationmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QualificationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualificationMicroserviceApplication.class, args);
	}

}
