package com.example.rocketmqproducer;

import com.example.rocketmqproducer.entity.User;
import com.example.rocketmqproducer.mapper.UserMapper;
import com.example.rocketmqproducer.service.ProducerService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class RocketmqProducerApplicationTests {

    @Resource
    private ProducerService producerService;

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }



    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        // Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }



    @Test
    void sendMessage() throws InterruptedException {
        log.info("开始发送信息");
        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    Thread.sleep(1000);
                    producerService.sendMessage("topicTest", String.valueOf(i));
                    log.info("sendmessage:" + i);
                }
            }
        };
        thread.start();
        Thread.sleep(100000);
    }

    @Test
    void sendTransactionMessage() throws InterruptedException {
        log.info("开始发送事务信息");
        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(1000);
                    producerService.sendMessageInTransaction("topicTransaction:tag1", String.valueOf(i));
                    log.info("sendmessage:" + i);
                }
            }
        };
        thread.start();
        Thread.sleep(100000);
    }

}
