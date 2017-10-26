package com.gnu.design.ioc.normal;

/**
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
public class Demo {
    public static void main(String[] args) {
        Car car = new Car();

        // 如果想把Tire类的size改成参数化的，需要依次改动Bottom和Car类
//        Car car = new Car(40);
    }
}
