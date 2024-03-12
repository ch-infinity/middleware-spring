package com.example.nettytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettytestApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NettytestApplication.class);
        springApplication.run(args);
    }

}
