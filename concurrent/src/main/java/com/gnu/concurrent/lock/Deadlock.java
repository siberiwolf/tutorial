package com.gnu.concurrent.lock;

/**
 * create deadlock
 * <p>
 * info from thread dump
 * Found one Java-level deadlock:
 * =============================
 * "Thread-2":
 * waiting to lock monitor 0x0000000057488508 (object 0x00000000d61b0d20, a java.lang.Object),
 * which is held by "Thread-1"
 * "Thread-1":
 * waiting to lock monitor 0x0000000057485a68 (object 0x00000000d61b0d30, a java.lang.Object),
 * which is held by "Thread-2"
 *
 * @author siberiwolf@hotmail.com on 2017-07-21
 */
public class Deadlock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj1) {
                        System.out.println("acquired lock of obj1");
                        Thread.sleep(100);
                        System.out.println("acquiring lock of obj2");
                        synchronized (obj2) {
                            System.out.println("acquired lock of obj2");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("Thread-1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj2) {
                        System.out.println("acquired lock of obj2");
                        Thread.sleep(100);
                        System.out.println("acquiring lock of obj1");
                        synchronized (obj1) {
                            System.out.println("acquired lock of obj1");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.setName("Thread-2");
        thread2.start();
    }
}
