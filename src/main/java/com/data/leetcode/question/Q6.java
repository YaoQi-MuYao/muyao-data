package com.data.leetcode.question;

import java.util.Arrays;

/**
 * @className: Q6
 * @author: muyao
 * @description:
 * @date: 2022/11/10 10:07 AM
 * @version: 1.0
 */
public class Q6 {

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * @author muyao
     * @date 2022/11/10 11:19 AM
     */
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
    }

    /**
     * 左右乘积列表
     *
     * @param nums 给定数组
     * @author muyao
     * @date 2022/11/10 11:18 AM
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] l = new int[length];
        int[] r = new int[length];
        int[] result = new int[length];

        l[0] = 1;
        r[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = l[i] * r[i];
        }

        return result;
    }
}
