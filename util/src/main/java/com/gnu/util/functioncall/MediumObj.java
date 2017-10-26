package com.gnu.util.functioncall;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 中间调用
 * @author siberiwolf@hotmail.com on 2017/9/30
 */
public class MediumObj {
    public String call() throws Exception {
        System.out.println(String.format("%s begin %s call()", Thread.currentThread().getName(), this.getClass().getSimpleName()));
        TimeUnit.SECONDS.sleep(3);
        System.out.println(String.format("%s finished %s call()", Thread.currentThread().getName(), this.getClass().getSimpleName()));
        return new String("OK");
    }

    public void callback(Object obj, Method method) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str = call();
                    method.invoke(obj, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
