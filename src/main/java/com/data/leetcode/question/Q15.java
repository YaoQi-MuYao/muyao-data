package com.data.leetcode.question;

import java.util.Arrays;

/**
 * 300 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 * @author XiaoXiao
 * @Date 2023/5/18 13:40
 **/
public class Q15 {

    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};
        int max = lengthOfLIS(nums);
        System.out.println(max);
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        int deq[] = new int[nums.length];
        Arrays.fill(deq, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) deq[i] = Math.max(deq[i], deq[j] + 1);
            }
            max = Math.max(max, deq[i]);
        }
        return max;
    }
}
