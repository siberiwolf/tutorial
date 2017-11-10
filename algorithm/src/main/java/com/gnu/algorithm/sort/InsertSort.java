package com.gnu.algorithm.sort;

import com.gnu.util.ListUtil;

/**
 * 插入排序
 * @author siberiwolf@hotmail.com on 2017/11/10
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {1, 9, 8, 0, 7, 4, 5, 2};
        // 以从小到大排序为例描述
        // 第一轮，比较array[0]和array[1]，将这两个元素排好序
        // 第二轮，比较array[2]和排好序的{array[0], array[1]}，如果array[2]大于array[1]，则三个元素
        // 都已经是有序的，继续下一轮处理，否则，交换array[2]和array[1]，并继续比较array[1]和array[0]
        // ...
        // 最后一轮，比较array[n-1]和排好序的{array[0],...,array[n-2]}

        int n = array.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }

        System.out.println(ListUtil.printIntList(array));
    }
}
