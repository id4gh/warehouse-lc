package com.lc.warehouse.leetcode;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName: Solution
 * @Author: mayanchao
 * @Description:
 * @Date: 2021/5/28 下午12:54
 */
public class Solution {


    public static int removeDuplicates(int[] nums) {
        try {
            int len = nums.length;
            if (len < 2) {
                return len;
            }
            int prei = 0;
            for (int i = 1; i < len; i++) {
                if (nums[prei] != nums[i]) {
                    nums[++prei] = nums[i];
                }
            }
            return ++prei;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> res = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).sorted().boxed().collect(Collectors.toList());
        int length = res.size();
        if (length == 0) {
            return 0D;
        } else if (length % 2 == 0) {
            return (double) (res.get((res.size() / 2) - 1) + res.get((res.size() / 2))) / 2;
        } else {
            return (double) res.get((res.size() / 2));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
