package com.ch.order.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ch.commoninterface.domain.UserAddress;
import com.ch.commoninterface.service.UserService;
import com.ch.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenhong
 * date 2024/1/8
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(retries = 3,timeout = 3000)
    UserService userService;
    @Override
    public void initOrder(String userId) {
        System.out.println("初始化订单"+ userId);

        System.out.println("开始远程获取地址");
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList.toString());

    }
}
