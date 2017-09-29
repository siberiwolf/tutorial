package com.gnu.number;

/**
 * 移位运算
 * @author siberiwolf@hotmail.com on 2017/9/29
 */
public class BitShiftDemo {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        System.out.println(String.format("binary string of x is %s", Integer.toBinaryString(x)));

        // 带符号左移, 低位补0, 移一位相当于乘以2, 移n位相当于乘以2的n次方
        int a = x << 2;
        System.out.println(String.format("binary string of a is %s", Integer.toBinaryString(a)));

        // 带符号右移, 高位补符号位, 正数补0, 负数补1
        int b = x >> 2;
        System.out.println(String.format("binary string of b is %s", Integer.toBinaryString(b)));

        // 无符号右移，高位补0
        int c = x >>> 2;
        System.out.println(String.format("binary string of c is %s", Integer.toBinaryString(c)));
    }
}
