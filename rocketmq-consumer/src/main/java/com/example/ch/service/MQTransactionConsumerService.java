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
@RocketMQMessageListener(topic = "topicTransaction",selectorExpression = "tag1", consumerGroup = "Con_Group_Two")
public class MQTransactionConsumerService implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("监听到tag1的事务消息:{}",s);
    }
}
