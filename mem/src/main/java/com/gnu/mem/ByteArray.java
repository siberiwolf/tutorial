package com.gnu.mem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 一个byte一个字节, src的大小是1024024字节(通过java visualVM获得)
 *
 * @author xuejiawei@lohogames.com on 2017-07-05
 */
public class ByteArray {
    public static void main(String[] args) {
        int length = 1024000;
        byte[] src = new byte[length];
        for (int i = 0; i < length; i++) {
            src[i] = 1;
        }

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(16);
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 遍历拷贝很慢
        List<Byte> dest = new ArrayList<Byte>();
        long begin = System.currentTimeMillis();
        for (byte b : src) {
            dest.add(b);
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("iterate copy begin %s end %s cost %s", begin, end, (end - begin)));

        // 比遍历拷贝快10倍
        byte[] dest2 = new byte[src.length];
        long begin2 = System.currentTimeMillis();
        System.arraycopy(src, 0, dest2, 0, length);
        long end2 = System.currentTimeMillis();
        System.out.println(String.format("guava copy begin %s end %s cost %s", begin2, end2, (end2 - begin2)));
    }
}
