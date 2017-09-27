package com.gnu.concurrent.lock;

import com.gnu.concurrent.lock.pojo.Boss;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用原子类打boss
 * @author siberiwolf@hotmail.com on 2017/9/27
 */
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicReference<Boss> reference = new AtomicReference<>(new Boss(10000, 0));

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (;;) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    int attack = (int) (Math.random() * 1000);
                    boolean flag = false;

                    while (!flag) {
                        Boss stored = reference.get();
                        if (stored.hp <= 0) {
                            break;
                        }

                        Boss updated = new Boss(stored.hp - attack, stored.total + attack);
                        flag = reference.compareAndSet(stored, updated);
                        if (flag) {
                            System.out.println(Thread.currentThread().getName() + " attack " + attack);
                        }

                        if (flag && updated.hp <= 0) {
                            System.out.println(Thread.currentThread().getName() + " hp " + updated.hp + " total " + updated.total);
                            System.exit(0);
                        }
                    }
                }
            });
        }
    }
}
