package com.lc.warehouse.verificationcode.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: MergeSort
 * @Author: mayanchao
 * @Description: 归并排序
 * @Date: 2021/10/16 下午4:34
 */
public class MergeSort {
    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (rightBound == leftBound) {
            return;
        }
        int mid = leftBound + ((rightBound - leftBound) >> 1);
        sort(arr, leftBound, mid);
        sort(arr, mid + 1, rightBound);

        merge(arr, leftBound, mid + 1, rightBound);
    }

    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        System.out.println("");
        System.out.println(JSONObject.toJSONString(arr));

        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }

        if (temp.length >= 0) {
            System.arraycopy(temp, 0, arr, leftPtr, temp.length);
        }

        System.out.println(JSONObject.toJSONString(arr));

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 4, 3, 2, 6, 1, 3};
        sort(arr, 0, arr.length - 1);
        System.out.println(JSONObject.toJSONString(arr));
    }
}
