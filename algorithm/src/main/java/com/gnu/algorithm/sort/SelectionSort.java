package com.gnu.algorithm.sort;

import com.gnu.util.ListUtil;

/**
 * 查询排序
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1, 9, 8, 0, 7, 4, 5, 2};

        for(int i = 0; i < array.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = array[i];
            array[i] = array[min_idx];
            array[min_idx] = temp;
        }

        System.out.println(ListUtil.printIntList(array));
    }
}
