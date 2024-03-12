package com.example.rocketmqproducer.service.impl;

import com.example.rocketmqproducer.dao.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.rocketmqproducer.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 服务接口实现
 *
 * @author chenhong
 * @since 2023-12-05 21:21:21
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

}