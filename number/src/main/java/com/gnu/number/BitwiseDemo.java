package com.gnu.number;

/**
 * 位运算
 * @author siberiwolf@hotmail.com on 2017/9/29
 */
public class BitwiseDemo {
    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        // 二进制
        System.out.println(String.format("binary string of x is %s", Integer.toBinaryString(x)));
        // 十六进制
        System.out.println(String.format("hex string of x is %s", Integer.toHexString(x)));
        // 八进制
        System.out.println(String.format("octal string of x is %s", Integer.toOctalString(x)));

        // 非
        int a = 0x00000000;
        int b = 0xFFFFFFFF;
        int c = ~a;
        int d = ~b;
        System.out.println(String.format("a is %s and c is %s", Integer.toBinaryString(a), Integer.toBinaryString(c)));
        System.out.println(String.format("b is %s and d is %s", Integer.toBinaryString(b), Integer.toBinaryString(d)));

        // 与, 两个都为真才得真
        System.out.println(String.format("0 and 0 is %s", Integer.toBinaryString(0 & 0)));
        System.out.println(String.format("0 and 1 is %s", Integer.toBinaryString(0 & 1)));
        System.out.println(String.format("1 and 0 is %s", Integer.toBinaryString(1 & 0)));
        System.out.println(String.format("1 and 1 is %s", Integer.toBinaryString(1 & 1)));

        // 或, 只要有一个为真则得真
        System.out.println(String.format("0 inclusive or 0 is %s", Integer.toBinaryString(0 | 0)));
        System.out.println(String.format("0 inclusive or 1 is %s", Integer.toBinaryString(0 | 1)));
        System.out.println(String.format("1 inclusive or 0 is %s", Integer.toBinaryString(1 | 0)));
        System.out.println(String.format("1 inclusive or 1 is %s", Integer.toBinaryString(1 | 1)));

        // 异或, 互斥或, 不同得真, 相同得假
        System.out.println(String.format("0 exclusive or 0 is %s", Integer.toBinaryString(0 ^ 0)));
        System.out.println(String.format("0 exclusive or 1 is %s", Integer.toBinaryString(0 ^ 1)));
        System.out.println(String.format("1 exclusive or 0 is %s", Integer.toBinaryString(1 ^ 0)));
        System.out.println(String.format("1 exclusive or 1 is %s", Integer.toBinaryString(1 ^ 1)));
    }
}
