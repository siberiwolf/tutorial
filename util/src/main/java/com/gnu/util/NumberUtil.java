package com.gnu.util;

/**
 * @author siberiwolf@hotmail.com on 2017-06-28
 */
public class NumberUtil {
    /**
     * 判断一个数是否为2的n次幂
     *
     * @param num
     * @return num是2的n次幂, 返回true
     */
    public static boolean powerOf2(int num) {
        return (num & (num - 1)) == 0;
    }

    /**
     * 计算大于等于num的最小的2的n次幂
     *
     * @param num
     * @return 大于等于num的最小的2的n次幂
     */
    public static int nextPowerOf2(int num) {
        int n = num - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    // TODO 位运算判断两个数相等
    // 两次同样的位操作
    // 50对相同的数，扔进去101个与其他都不同的，怎么找出来
}
