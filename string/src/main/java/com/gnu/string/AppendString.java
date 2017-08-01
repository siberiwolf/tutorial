package com.gnu.string;

/**
 * different append string
 */
public class AppendString {
    public static void main(String[] args) {
        String str = 1 + 2 + "aaa";
        // output 3aaa
        System.out.println(str);

        StringBuilder builder = new StringBuilder();
        builder.append(1).append(2).append("aaa");
        // output 12aaa
        System.out.println(builder.toString());
    }

}
