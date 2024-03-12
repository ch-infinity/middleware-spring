package com.ch.userserviceprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ch.commoninterface.domain.UserAddress;
import com.ch.commoninterface.service.UserService;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

/**
 * @author chenhong
 * date 2024/1/8
 **/
@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("本地获取地址开始");
        return Arrays.asList(new UserAddress("长沙"));
    }
}
