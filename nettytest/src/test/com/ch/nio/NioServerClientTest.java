package com.ch.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author chenhong
 * date 2024/1/29
 **/
public class NioServerClientTest {
    public static void main(String[] args) {
        SocketChannel sc = null;
        try {
            sc = SocketChannel.open();
            sc.connect(new InetSocketAddress(8080));
            sc.write(Charset.defaultCharset().encode("1234567890abcdef"));
            System.out.println("waiting");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
