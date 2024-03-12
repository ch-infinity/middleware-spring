package com.example.ch.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author chenhong
 * date 2023/12/5
 **/
@Service
@Slf4j
@RocketMQMessageListener(topic = "topicTest", consumerGroup = "Con_Group_One")
public class MQConsumerService implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("监听到消息:{}",s);
    }
}
