package com.example.rocketmqproducer.dao;

import lombok.extern.slf4j.Slf4j;
import com.example.rocketmqproducer.entity.User;
import com.example.rocketmqproducer.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * (t_user)数据DAO
 *
 * @author chenhong
 * @since 2023-12-05 21:21:21
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@Repository
public class UserDao extends ServiceImpl<UserMapper, User> {

}