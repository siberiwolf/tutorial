package com.gnu.design.ioc.dependency;

/**
 * @author siberiwolf@hotmail.com on 2017/10/26
 */
public class Demo {
    public static void main(String[] args) {
        // 改动size不再需要改动上层类
        // 考虑系统不是由三个类构成，依赖链很长，100个类？？？
        // 所以spring引入ioc container，new Car的时候不需要关心依赖链的具体构成，spring会自动寻找依赖关系
        // Car-->Bottom-->Tire，这个依赖关系存在于xml配置中，可以进行版本控制
        int size = 40;
        Tire tire = new Tire(40);
        Bottom bottom = new Bottom(tire);
        Car car = new Car(bottom);
    }
}
