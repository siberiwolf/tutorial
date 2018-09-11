package com.gnu.collection.stack;

import java.util.Iterator;

/**
 * 基于数组的下压栈(LIFO)实现
 *
 * @author xuejiawei@jd.com
 * 2018-06-09
 */
public class ArrayListStack<E> implements Stack<E> {
    // 存放集合元素的容器
    private Object[] items = new Object[1];
    // 元素个数
    private int number;

    @Override
    public int size() {
        return number;
    }

    @Override
    public boolean isEmpty() {
        return number == 0;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
