package com.lc.warehouse.verificationcode.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: BubbleSort
 * @Author: mayanchao
 * @Description: 冒泡排序
 * @Date: 2021/10/16 下午2:34
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 交换次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //相邻比较
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }//经过一轮循环，就可以找出第一个最大值的索引，然后把最大值放到最后的位置

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 4, 3, 2, 6, 1, 3};
        sort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }
}
