package com.ch.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * @author chenhong
 * date 2024/1/30
 **/
@Slf4j
public class NioSelectServerTest {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try (ServerSocketChannel ssc = ServerSocketChannel.open()) {
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(8080));
            SelectionKey ssck = ssc.register(selector, 0);
            ArrayList<SocketChannel> socketChannelArrayList = new ArrayList<>();
            while(true){
                SocketChannel sc = ssc.accept();
                if(sc != null){
                    log.debug("connected.....{}",sc);
                    sc.configureBlocking(false);
                    socketChannelArrayList.add(sc);
                }
                for (SocketChannel socketChannel : socketChannelArrayList) {
                    int read = socketChannel.read(byteBuffer);
                    if(-1!=read){
                        byteBuffer.flip();
                        while(byteBuffer.hasRemaining()){
                            System.out.println(byteBuffer.get());
                        }
                        byteBuffer.clear();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }
}
