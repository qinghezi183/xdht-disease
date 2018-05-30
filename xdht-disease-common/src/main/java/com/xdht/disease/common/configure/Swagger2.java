package com.xdht.disease.common.configure;

import com.xdht.disease.common.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lzf
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xdht.disease"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(User.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("clearing RESTful APIs")
                .description("")
                .termsOfServiceUrl("http://www.demo.com/")
                .version("1.0")
                .build();
    }

}
