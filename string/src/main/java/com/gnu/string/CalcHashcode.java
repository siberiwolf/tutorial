package com.gnu.string;

/**
 * String的hashcode为什么要那么算
 *
 * @author siberiwolf@hotmail.com on 2017/9/29
 */
public class CalcHashcode {
    // 一个对象多次执行hashcode方法, hashcode应该是不变的
    // 两个对象如果equals, 则他们的hashcode应该相等
    // 两个对象如果不equals, 不保证他们的hashcode一定不相等, 不过如果这种情况, 能提供保证不相等的hashcode计算方法,有助于提升hashtable性能

    // s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
    // for (int i = 0; i < value.length; i++) {
    //      h = 31 * h + val[i];
    // }
    // i = 0, h = 31 * h + val[0]
    // i = 1, h = 31 * (31 * h + val[0]) + val[1] = 31^2 * h + 31 * val[0] + val[1]
    // i = 2, h = 31 * (31^2 * h + 31 * val[0] + val[1]) + val[2] = 31^3 * h + 31^2 * val[0] + 31 * val[1] + val[2]
    // h = 0往里代入, 所以数组的hashcode包含了数组里所有元素的信息, 为什么要选31, 看下面的计算变化

    // 31 * i = (i << 5) - i
    // i * 31 = i * (32 - 1) = i * 32 - i = (i << 5) - i
    // Modern VMs do this sort of optimization automatically, 为什么不用15呢, 为什么不用63呢???
}
