package com.ch.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chenhong
 * date 2024/1/28
 **/
@Slf4j
public class TestByteBuffer {

    public static void main(String[] args)  {
        try {
            FileChannel channel = new FileInputStream("data.txt").getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while(channel.read(buffer)!=-1){
                buffer.flip();
                while(buffer.hasRemaining()){
                    byte b = buffer.get();
                    log.debug("实际字节:{}",(char)b);
                }
                buffer.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
