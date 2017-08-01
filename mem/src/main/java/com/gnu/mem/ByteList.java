package com.gnu.mem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 一个Byte是一个对象，占用？个字节，list的大小是9723952字节(通过java visualVM获得)
 *
 * @author xuejiawei@lohogames.com on 2017-07-06
 */
public class ByteList {
    public static void main(String[] args) {
        int length = 1024000;
        List<Byte> list = new ArrayList<Byte>();
        for (int i = 0; i < length; i++) {
            list.add((byte) 1);
        }


        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(16);
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
