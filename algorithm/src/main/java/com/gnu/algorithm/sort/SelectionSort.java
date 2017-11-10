package com.gnu.algorithm.sort;

import com.gnu.util.ListUtil;

/**
 * 搜索排序
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1, 9, 8, 0, 7, 4, 5, 2};
        // 第一轮，查找出array[0]至array[n-1]中最小的元素，和array[0]交换
        // 第二轮，查找出array[1]至array[n-1]中最小的元素，和array[1]交换
        // ...
        // 最后一轮比较array[n-2]和array[n-1]，排序结束

        int n = array.length;
        for(int i = 0; i < n; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }

            if (min_idx != i) {
                int temp = array[i];
                array[i] = array[min_idx];
                array[min_idx] = temp;
            }
        }

        System.out.println(ListUtil.printIntList(array));
    }
}
