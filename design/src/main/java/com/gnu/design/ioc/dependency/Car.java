package com.gnu.design.ioc.dependency;

/**
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
public class Car {
    private Bottom bottom;

    Car(Bottom bottom) {
        this.bottom = bottom;
    }
}
