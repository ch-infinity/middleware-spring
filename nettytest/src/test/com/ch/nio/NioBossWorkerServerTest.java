package com.ch.nio;

import lombok.extern.slf4j.Slf4j;
import sun.misc.CharacterDecoder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author chenhong
 * date 2024/1/31
 **/
@Slf4j
public class NioBossWorkerServerTest {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss");
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        Selector bossSelector = Selector.open();
        ssc.register(bossSelector, SelectionKey.OP_ACCEPT,0);
        ssc.bind(new InetSocketAddress(8080));
        Worker worker0 = new Worker("work-0");
        while(true){
            bossSelector.select();
            Iterator<SelectionKey> iterator = bossSelector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if(key.isAcceptable()){
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    log.debug("connected...{}",sc.getRemoteAddress());
                    log.debug("before register...{}",sc.getRemoteAddress());
                    worker0.register();
                    sc.register(worker0.worker, SelectionKey.OP_READ,0);
                    log.debug("after register...{}", sc.getRemoteAddress());
                }
            }
        }




    }
    static class Worker implements Runnable{
        private Thread thread;
        private Selector worker;
        private String name;
        private volatile boolean start = false;


        public Worker(String name) {
            this.name = name;
        }

        public void register() throws IOException {
            if(!start){
                thread = new Thread(this, name);
                worker = Selector.open();
                thread.start();
                start = true;
            }
        }
        @Override
        public void run() {
            while(true){
                try {
                    worker.select();
                    Iterator<SelectionKey> iterator = worker.selectedKeys().iterator();
                    while(iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if(key.isReadable()){
                            try {
                                ByteBuffer byteBuffer = ByteBuffer.allocate(16);
                                SocketChannel channel = (SocketChannel) key.channel();
                                int read = channel.read(byteBuffer);
                                if(read == -1){
                                    key.cancel();
                                }
                                byteBuffer.flip();
                                log.debug("byteBuffer:{}", Charset.forName("UTF-8").decode(byteBuffer));
                            } catch (IOException e) {
                                key.cancel();
                            }
                        }
                    }
                } catch (IOException e) {

                }
            }
        }
    }
}
