package com.gnu.algorithm.sort;

import com.gnu.util.ListUtil;

/**
 * 冒泡排序
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 9, 8, 0, 7, 4, 5, 2};

        // 第一轮循环，处理array[0]至array[n-1]，把最大的数排到最后，结果{1, 8, 0, 7, 4, 5, 2, 9}
        // 第二轮循环，处理array[0]至array[n-2]，把第二大的数，排到倒数第二位，结果{1, 0, 7, 4, 5, 2, 8, 9}
        // ...
        // 最后一轮比较array[0]和array[1]，排序结束
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
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
