package com.gnu.design.aop.proxy;

/**
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
public class Demo {
    public static void main(String[] args) {
        A b = new AProxy(new B());
        b.doSomething();

        // 现在考虑有N个类实现了A接口，比如类C、D、E、F、G等等，很多很多
        // 现在需要在执行doSomething之前做个打印，可以看到AProxy类的好处了吧
        // 如果没有AProxy类，需要改动C、D、E、F、G等等类的doSomething方法
        // TODO 这是静态代理，动态代理呢？？？
        A c = new AProxy(new C());
        c.doSomething();
    }

}
