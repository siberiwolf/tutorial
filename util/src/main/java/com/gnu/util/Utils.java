package com.gnu.util;

/**
 * @author xuejiawei@lohogames.com on 2017-06-28
 */
public class Utils {
    /**
     * 判断一个数是否为2的n次幂
     * @param num
     * @return  num是2的n次幂, 返回true
     */
    public static boolean powerOf2(int num) {
        return (num & (num - 1)) == 0;
    }

    /**
     * 计算大于等于num的最小的2的n次幂
     * @param num
     * @return  大于等于num的最小的2的n次幂
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
}
