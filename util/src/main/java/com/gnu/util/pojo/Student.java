package com.gnu.util.pojo;

/**
 * what is a pojo(Plain Old Java Object) object
 * 1. not extend any prespecified classes
 * 2. not implement any prespecified interface
 * 3. not contain any prespecified annotation
 *
 * what is a java bean
 * 1. all properties private(use getter and setter)
 * 2. a public no-argument constructor
 * 3. implement {@link java.io.Serializable}
 * @author siberiwolf@hotmail.com on 2017/9/25
 */
public class Student {
    private int id = 1;

    public int getId() {
        return id;
    }
}
