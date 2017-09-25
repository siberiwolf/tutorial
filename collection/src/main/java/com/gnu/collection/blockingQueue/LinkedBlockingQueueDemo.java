package com.gnu.collection.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * optionally-bounded阻塞队列, based on linked node
 *
 * @author siberiwolf@hotmail.com on 2017/9/21
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        // unbounded
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        // bounded
//        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(16);

        for (int i = 0; i < 5; i++) {
            final int id = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 4; j++) {
                        try {
                            queue.put(id * 4 + j);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "producer_thread_" + id);
            thread.start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println(String.format("There are %d items in queue", queue.size()));

        for (; ; ) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Consumer is interrupted");
                break;
            }
            // poll will waiting for special time or return null when timeout or throw InterruptedException
            Integer item = queue.poll(3, TimeUnit.SECONDS);
            if (item != null) {
                System.out.println(String.format("Retrieve %d from queue", item.intValue()));
            } else {
                System.out.println("Retrieve timeout");
                break;
            }
        }
    }
}
