package com.gnu.design.ioc.normal;

/**
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
public class Bottom {
    private Tire tire;

    Bottom() {
        tire = new Tire();
    }

    /*Bottom(int size) {
        tire = new Tire(size);
    }*/
}
