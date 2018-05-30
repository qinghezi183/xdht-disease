package com.xdht.disease.sys;

import com.xdht.disease.common.authorization.resolvers.CurrentUserMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.xdht.disease.common","com.xdht.disease.sys"})
public class XdhtDiseaseSysApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(XdhtDiseaseSysApplication.class, args);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		argumentResolvers.add(new CurrentUserMethodArgumentResolver());
	}

}
