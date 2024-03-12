package com.ch.netty;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author chenhong
 * date 2024/1/31
 **/
public class EventLoopTest {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup(); // io 事件，普通任务，定时任务
        // EventLoopGroup group = new DefaultEventLoopGroup(); // 普通任务，定时任务


    }
}
