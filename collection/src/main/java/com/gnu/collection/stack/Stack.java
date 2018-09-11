package com.gnu.collection.stack;

import java.util.Iterator;

/**
 * @author xuejiawei@jd.com
 * 2018-06-09
 */
public interface Stack<E> extends Iterable<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E pop();

    @Override
    Iterator<E> iterator();
}
