package com.gnu.collection.array;

/**
 * 探索a++和++a的区别
 * @author siberiwolf@hotmail.com on 2017/9/29
 */
public class ByteArray {
    public static void main(String[] args) {
        byte[] array = {0, 1, 2};
        int index = 0;
        // get array[0] and index change to 1, index先用后加
        /*byte b = array[index++];
        System.out.println(String.format("index is %d", index));
        System.out.println(String.format("byte is %d", b));*/

        // get array[1] and index change to 1, index先加后用
        byte b = array[++index];
        System.out.println(String.format("index is %d", index));
        System.out.println(String.format("byte is %d", b));
    }
}
