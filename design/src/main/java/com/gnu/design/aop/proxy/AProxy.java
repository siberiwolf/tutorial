package com.gnu.design.aop.proxy;

/**
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
public class AProxy implements A{
    private A a;

    AProxy(A a) {
        this.a = a;
    }

    @Override
    public void doSomething() {
        System.out.println("Haha, i am a proxy");
        a.doSomething();
    }
}
