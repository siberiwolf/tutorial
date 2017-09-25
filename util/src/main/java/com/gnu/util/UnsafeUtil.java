package com.gnu.util;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * use of unsafe class
 *
 * @author siberiwolf@hotmail.com on 2017/9/22
 */
public final class UnsafeUtil {
    // static final variable can be initialized in static block without GOTO in static block
    // try catch essentially a GOTO, if exception thrown, theUnsafe will not be initialized
    /*private static final Unsafe theUnsafe;
    static {
        try {
            Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
            unsafeConstructor.setAccessible(true);
            theUnsafe = unsafeConstructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private static final Unsafe theUnsafe = createUnsafe();

    private static Unsafe createUnsafe() {
        try {
            Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
            unsafeConstructor.setAccessible(true);
            return unsafeConstructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 构造一个类实例
     * allocateInstance method can be useful when you need to skip object initialization phase or
     * bypass security checks in constructor or you want instance of that class but don’t have any public constructor.
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Object createObj(Class<?> clazz) throws Exception {
        return theUnsafe.allocateInstance(clazz);
    }

    /**
     * 改变私有属性的值
     * @param obj
     * @param fieldName
     * @param value
     * @throws Exception
     */
    public static void changePrivateIntField(Object obj, String fieldName, int value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        long offset = theUnsafe.objectFieldOffset(field);
        theUnsafe.putInt(obj, offset, value);
    }

}
