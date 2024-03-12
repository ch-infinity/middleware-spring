package com.ch.userserviceprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class UserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApplication.class, args);
    }

}

// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
//
// import java.io.IOException;
//
// public class UserServiceProviderApplication{
//     public static void main(String[] args) throws IOException {
//         ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
//         ioc.start();
//
//         System.in.read();
//     }
// }
