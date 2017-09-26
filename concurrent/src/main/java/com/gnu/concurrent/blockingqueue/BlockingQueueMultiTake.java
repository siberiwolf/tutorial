package com.gnu.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程并发从空的ArrayBlockingQueue获取元素
 * @author siberiwolf@hotmail.com on 2017/9/26
 */
public class BlockingQueueMultiTake {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(16);

        // 所有线程都阻塞在notEmpty.await()
        // take方法会先获取lock.lockInterruptibly(), 如果获取到锁, 在队列为空的情况下, 调用
        // notEmpty.await(), 释放ReentrantLock中Sync的state并使当前线程阻塞, 而其他线程可以获取锁
        // 如果锁被其他线程持有, 调用AQS.addWaiter排到队尾, 调用AQS.acquireQueued自旋尝试获取锁
        /*for (;;) {
            final Node p = node.predecessor();
            if (p == head && tryAcquire(arg)) {
                setHead(node);
                p.next = null; // help GC
                failed = false;
                return interrupted;
            }
        }*/
        // 默认非公平锁，后来的线程有可能通过compareAndSetState比排队中的线程更先获得锁
        // 公平锁的核心在于hasQueuedPredecessors判断之后才进行compareAndSetState获取锁
        /*
        "pool-1-thread-1" #14 prio=5 os_prio=0 tid=0x000000001e89a800 nid=0x21ec waiting on condition [0x000000001f7df000]
        java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
                - parking to wait for  <0x000000076add71d0> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
        at java.util.concurrent.ArrayBlockingQueue.take(ArrayBlockingQueue.java:403)
        at com.gnu.concurrent.blockingqueue.BlockingQueueMultiTake$1.run(BlockingQueueMultiTake.java:21)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)

        Locked ownable synchronizers:
        - <0x000000076addb2d0> (a java.util.concurrent.ThreadPoolExecutor$Worker)
        */
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
