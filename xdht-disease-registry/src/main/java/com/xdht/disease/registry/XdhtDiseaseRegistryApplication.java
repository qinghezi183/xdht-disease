package com.xdht.disease.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XdhtDiseaseRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdhtDiseaseRegistryApplication.class, args);
	}
}
