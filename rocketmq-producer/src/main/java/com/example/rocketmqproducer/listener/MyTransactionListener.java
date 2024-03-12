package com.example.rocketmqproducer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;

/**
 * @author chenhong
 * date 2023/12/5
 **/
@RocketMQTransactionListener(rocketMQTemplateBeanName = "rocketMQTemplate")
@Slf4j
public class MyTransactionListener implements RocketMQLocalTransactionListener {
    /**
    * @description 执行本地事务
    * @param message :
    * @param o :
    * @return
    * @exception
    * @author      chenhong
    * @date        2023/12/5 17:15
    **/
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        String destination = (String) o;
        log.info("本地事务执行消息：{}",message);
        org.apache.rocketmq.common.message.Message rocketMessage = RocketMQUtil.convertToRocketMessage(new StringMessageConverter(), "utf-8", destination, message);
        String tags = rocketMessage.getTags();
        log.info("本地事务回调tag:{}",tags);
        try{
            Thread.sleep(2000);
            byte[] body = rocketMessage.getBody();
            String bodyStr = new String(body);
            if(Integer.valueOf(bodyStr)%2 == 0){
                throw new Exception();
            }
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e){
            return RocketMQLocalTransactionState.ROLLBACK;
        }finally {

        }

    }

    /**
    * @description 检查本地消息
    * @param message :
    * @return
    * @exception
    * @author      chenhong
    * @date        2023/12/5 17:16
    **/
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        // 如果本地事务执行后返回RocketMQLocalTransactionState.UNKNOWN，则会触发该方法重新查询事务执行状态，默认15次回查后还没有结果则丢弃该事务
        log.info("回查本地事务:{}",message);


        return RocketMQLocalTransactionState.UNKNOWN;
    }
}
