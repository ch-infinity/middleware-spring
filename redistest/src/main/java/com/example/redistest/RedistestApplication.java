package com.example.redistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedistestApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RedistestApplication.class);
        springApplication.run(args);
    }

}
