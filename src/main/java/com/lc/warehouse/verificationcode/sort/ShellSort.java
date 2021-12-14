package com.lc.warehouse.verificationcode.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @ClassName: ShellSort
 * @Author: mayanchao
 * @Description: 希尔排序
 * @Date: 2021/10/16 下午3:39
 */
public class ShellSort {

    public static void sort(int[] arr) {

        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }
        System.out.println(h);
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j - gap, j);
                    }
                    System.out.println(JSONObject.toJSONString(arr));
                    setSign(j - gap, j);
                }
            }
            System.out.println("==============================");
        }
    }

    private static void setSign(int a, int b) {
        if (a > b) {
            int c = b;
            b = a;
            a = c;
        }
        System.out.print(" ");
        for (int i = 0; i < a; i++) {
            System.out.print("  ");
        }
        System.out.print("- ");
        for (int i = a + 1; i < b; i++) {
            System.out.print("  ");
        }
        System.out.print("- ");
        System.out.println("");
        System.out.println("");
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int arr[] = new int[]{1, 5, 4, 3, 2, 6, 1, 3};
        int arr[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(JSONObject.toJSONString(arr));
        Arrays.sort(arr);
        sort(arr);
    }
}
