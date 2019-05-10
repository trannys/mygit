package com.lucq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by dell on 2018/10/16.
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan
public class TestService1Application {

    public static void main(String[] args) {
        SpringApplication.run(TestService1Application.class, args);
    }


}
