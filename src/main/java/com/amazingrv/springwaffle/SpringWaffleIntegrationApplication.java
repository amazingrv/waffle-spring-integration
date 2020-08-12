package com.amazingrv.springwaffle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
public class SpringWaffleIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWaffleIntegrationApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.springwaffle.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Waffle SpringBoot 2 Integration",
                "Rest API demo for authentication using Waffle",
                "v1",
                null,
                new Contact("Rajat Verma", "https://github.com/amazingrv", "i.rajatverma21@gmail.com"),
                "MIT License", null,
                Collections.emptyList());
    }

}
