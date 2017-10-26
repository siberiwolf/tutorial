package com.gnu.mem;

/**
 * @author siberiwolf@hotmail.com on 2017/10/21
 */
public class FinalDemo {
    public final Object x;

    public FinalDemo(Object x) {
        this.x = x;
    }

    public static void main(String[] args) {
        FinalDemo demo = new FinalDemo(new Object());
        // compiler error
//        demo.x = 10;
    }
}
