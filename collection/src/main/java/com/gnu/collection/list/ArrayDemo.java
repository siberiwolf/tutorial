package com.gnu.collection.list;

import javax.naming.NameNotFoundException;
import java.util.concurrent.TimeUnit;

/**
 * Java中的数组使用
 * @author siberiwolf@hotmail.com on 2017/9/8
 */
public class ArrayDemo {
    public static void main(String[] args) throws Exception{
        // An array is a container object that holds a fixed number of values of a single type.
        // array的长度固定
        // array里面必须包含同一种元素

        // compiler error
        // int[] anArray = {1, 2, 3, 4.0D};

        Object[] a = {null};

        int[] anArray = new int[1024];

        for (int i = 0; i < 1024; i++){
            anArray[i] = i;
        }

        // runtime error ArrayIndexOutOfBoundsException
        anArray[1024] = 0;

//        TimeUnit.SECONDS.sleep(30);
    }
}
