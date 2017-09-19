package com.gnu.util;

/**
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class ListUtil {
    public static String printIntList(int[] list) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int k : list) {
            builder.append(k).append(",");
        }
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }
}
