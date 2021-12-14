package com.lc.warehouse.verificationcode.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: sort
 * @Author: mayanchao
 * @Description: 选择排序
 * @Date: 2021/10/16 下午2:28
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 交换次数
            // 先假设每次循环时，最小数的索引为i
            int minIndex = i;// 每一个元素都和剩下的未排序的元素比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {//寻找最小数
                    minIndex = j;//将最小数的索引保存
                }
            }//经过一轮循环，就可以找出第一个最小值的索引，然后把最小值放到i的位置
            swap(arr, i, minIndex);
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
