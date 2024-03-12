package com.ch.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.ch.order.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@EnableDubbo
@SpringBootApplication
public class OrderServiceConsumerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OrderServiceConsumerApplication.class, args);
    }

}
