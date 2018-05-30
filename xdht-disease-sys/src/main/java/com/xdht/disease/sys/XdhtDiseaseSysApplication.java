package com.xdht.disease.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.xdht.disease.common","com.xdht.disease.sys"})
public class XdhtDiseaseSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdhtDiseaseSysApplication.class, args);
	}
}
