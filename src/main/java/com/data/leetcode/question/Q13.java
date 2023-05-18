package com.data.leetcode.question;

/**
 * 27 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author XiaoXiao
 * @Date 2023/5/16 19:55
 **/
public class Q13 {
    public static void main(String[] args) {
        int a[] = {1,2,2,2,4,5};
        int i = removeElement(a, 2);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int end = 0;
        for (int start = 0; start < nums.length; start++) {
            if (nums[start] != val) {
                nums[end] = nums[start];
                end++;
            }
        }
        return end;
    }
}
