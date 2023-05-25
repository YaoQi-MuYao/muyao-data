package com.data.leetcode.question;

import java.util.Arrays;

/**
 * @className: Q15
 * @author: muyao
 * @description:
 * @date: 2023/5/18 10:48 AM
 * @version: 1.0
 */
public class Q15 {

    public static void main(String[] args) {
        int a[] = {10,9,2,5,3,7,21,18};
        int length = lengthOfLIS(a);
        System.out.println(length);
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
