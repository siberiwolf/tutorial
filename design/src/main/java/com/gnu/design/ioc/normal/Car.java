package com.gnu.design.ioc.normal;

/**
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
public class Car {
    private Bottom bottom;

    Car() {
        bottom = new Bottom();
    }

    /*Car(int size) {
        bottom = new Bottom(size);
    }*/

}
