package com.gnu.util.functioncall;

/**
 * 方法同步调用
 * @author siberiwolf@hotmail.com on 2017/9/30
 */
public class SyncDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(String.format("%s begin call medium function", Thread.currentThread().getName()));
        MediumObj medium = new MediumObj();
        // main thread call and waiting medium.call() return, main thread blocked
        System.out.println(String.format("%s get medium call() return value %s",Thread.currentThread().getName(), medium.call()));
        System.out.println(String.format("%s end call medium function", Thread.currentThread().getName()));
    }
}
