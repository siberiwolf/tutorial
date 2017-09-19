package com.gnu.algorithm.sort;

import com.gnu.util.ListUtil;

/**
 * 冒泡排序
 *
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 9, 8, 0, 7, 4, 5, 2};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println(ListUtil.printIntList(array));
    }
}
