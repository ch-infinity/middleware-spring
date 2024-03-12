package com.ch.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author chenhong
 * date 2024/1/29
 **/
public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try {
            FileChannel from = new FileInputStream("data.txt").getChannel();
            FileChannel to = new FileOutputStream("data1.txt").getChannel();
            from.transferTo(0, from.size(), to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
