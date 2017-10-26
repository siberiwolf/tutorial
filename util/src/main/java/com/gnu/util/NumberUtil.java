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

    // 50对相同的数，扔进去一个与其他都不同的，怎么找出来
    // 关键点：异或操作 X^X=0；X^0=X；A^B^C=A^C^B(异或满足交换律)
    // 50对相同的数异或的结果为0，再异或一个不同的，得到的结果就是那个不同的
    public static int findDiff() {
        int[] array = {1, 2, 3, 4, 1, 3, 2, 5, 6, 6, 5};
        int diff = 0;
        for (int i = 0; i < array.length; i++) {
            diff ^= array[i];
        }
        return diff;
    }

}
