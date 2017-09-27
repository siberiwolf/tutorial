package com.gnu.concurrent.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用锁打boss
 * @author siberiwolf@hotmail.com on 2017/9/27
 */
public class ReentrantLockDemo {
    volatile double hp = 10000D;
    volatile double total = 0D;

    public static void main(String[] args) {
        final ReentrantLockDemo demo = new ReentrantLockDemo();

        Lock lock = new ReentrantLock();
        ExecutorService executor = Executors.newCachedThreadPool();
        for(;;) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    double attack = Math.random() * 1000;
                    try {
                        lock.lock();
                        demo.hp -= attack;
                        demo.total += attack;
                        if (demo.hp <= 0) {
                            System.out.println(Thread.currentThread().getName() + " final attack " + attack);
                            System.out.println("total attack " + demo.total);
                            System.exit(0);
                        } else {
                            System.out.println(Thread.currentThread().getName() + " attack " + attack);
                        }
                    } finally {
                        lock.unlock();
                    }

                }
            });
        }

    }
}
