package com.xdht.disease.shunfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.xdht.disease.common","com.xdht.disease.shunfeng"})
public class XdhtDiseaseShunfengApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdhtDiseaseShunfengApplication.class, args);
	}
}
