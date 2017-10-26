package com.gnu.util.functioncall;

import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * @author siberiwolf@hotmail.com on 2017/9/30
 */
public class CallbackDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(String.format("%s begin call medium function", Thread.currentThread().getName()));
        MediumObj medium = new MediumObj();
        CallbackDemo demo = new CallbackDemo();
        Method method = demo.getClass().getMethod("printResult", String.class);
        medium.callback(demo, method);
        System.out.println(String.format("%s end call medium function", Thread.currentThread().getName()));
    }

    public void printResult(String result) {
        System.out.println(String.format("%s get medium callback() return value %s",Thread.currentThread().getName(), result));
    }
}
