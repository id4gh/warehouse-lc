package com.lc.warehouse.verificationcode.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: InsertionSort
 * @Author: mayanchao
 * @Description: 插入排序
 * @Date: 2021/10/16 下午3:22
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                }
            }
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
