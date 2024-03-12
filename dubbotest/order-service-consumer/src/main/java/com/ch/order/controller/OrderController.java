package com.ch.order.controller;

import com.ch.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenhong
 * date 2024/1/8
 **/
@RestController
public class OrderController{

    @Autowired
    private OrderService orderService;

    @GetMapping("/initOrder/{orderId}")
    public void initOrder(@PathVariable String orderId){
        orderService.initOrder(orderId);
    }
}
