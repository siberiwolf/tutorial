package com.gnu.collection.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author siberiwolf@hotmail.com on 2017/9/21
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
    }
}
