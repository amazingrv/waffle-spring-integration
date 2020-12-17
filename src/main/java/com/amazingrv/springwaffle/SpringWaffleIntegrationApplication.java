package com.amazingrv.springwaffle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author rjat3
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringWaffleIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWaffleIntegrationApplication.class, args);
    }

}
