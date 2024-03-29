package com.ch.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenhong
 * date 2024/2/1
 **/
@Slf4j
public class TestPipeline {
    public static void main(String[] args) {
        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        pipeline.addLast("h1",new ChannelInboundHandlerAdapter(){

                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("1");
                                super.channelRead(ctx, msg);
                            }
                        });
                        pipeline.addLast("h2",new ChannelInboundHandlerAdapter(){

                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("2");
                                super.channelRead(ctx, msg);
                            }
                        });
                        pipeline.addLast("h3",new ChannelInboundHandlerAdapter(){

                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("3");
                                super.channelRead(ctx, msg);
                                nioSocketChannel.writeAndFlush(ctx.alloc().buffer().writeBytes("server...".getBytes()));
                            }
                        });
                        pipeline.addLast("h4",new ChannelOutboundHandlerAdapter(){

                            @Override
                            public void write(ChannelHandlerContext ctx, Object msg,ChannelPromise promise) throws Exception {
                                log.debug("4");
                                super.write(ctx, msg,promise);
                            }
                        });
                    }
                }).bind(8080);
    }
}
