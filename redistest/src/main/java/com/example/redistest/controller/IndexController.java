package com.example.redistest.controller;

import com.esotericsoftware.kryo.util.Null;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author chenhong
 * date 2023/11/28
 **/
@RestController
public class IndexController {

    @Autowired
    private RedissonClient redissonClient;


    private final String LOCK_KEY = "CH";

    @GetMapping("/deduct")
    public String deductStock() {
        RLock lock = redissonClient.getLock(LOCK_KEY);
        try {
            boolean locked = lock.isLocked();
            if(locked) {
                throw new NullPointerException();
            }
            lock.lock();
            System.out.println("开始执行获取到锁后的逻辑");
            Thread.sleep(5000);
            System.out.println("获取到锁后的逻辑执行结束");
        } catch (Exception e) {
            System.out.println("报错了");
        } finally {
            System.out.println("释放锁");
            lock.unlock();
        }

        return "xxx";
    }


}
