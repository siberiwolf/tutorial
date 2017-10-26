package com.gnu.util.functioncall;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 方法异步调用
 *
 * @author siberiwolf@hotmail.com on 2017/9/30
 */
public class AsyncDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(String.format("%s begin call medium function", Thread.currentThread().getName()));
        // main thread create new thread to call medium.call(), main thread return immediately
        // runnable can not return execute result
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                MediumObj medium = new MediumObj();
                try {
                    String result = medium.call();
                    System.out.println(String.format("%s get medium call() return value %s",Thread.currentThread().getName(), result));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> result = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                MediumObj medium = new MediumObj();
                return medium.call();
            }
        });
        System.out.println(String.format("%s end call medium function", Thread.currentThread().getName()));
        // main thread 主动要求获得异步操作的结果, 如果结果未准备好, main thread block
        String str = result.get();
        System.out.println(String.format("%s get medium call() return value %s",Thread.currentThread().getName(), str));
    }
}
