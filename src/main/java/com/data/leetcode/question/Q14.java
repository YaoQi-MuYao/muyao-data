package com.data.leetcode.question;

/**
 * 35 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 * @author XiaoXiao
 * @Date 2023/5/16 22:14
 **/
public class Q14 {
    public static void main(String[] args) {
        int nums[] = {2, 3, 5, 6, 9};
        int i = searchInsert1(nums, 7);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        int l = nums.length - 1;
        if (nums[0] > target) return 0;
        if (nums[l] < target) return nums.length;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == l) {
                if (nums[i] >= target) {
                    r = i;
                } else {
                    r = i + 1;
                }
                break;
            } else if (nums[i] >= target) {
                r = i;
                break;
            } else if (nums[l] < target) {
                r = l + 1;
                break;
            } else if (nums[l] == target) {
                r = l;
                break;
            } else {
                l--;
            }
        }
        return r;
    }
    /**
      * 二分法
      *  https://leetcode.cn/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
      * @author muyao
      * @date 2023/5/17 0:34
      * @param
      **/
    public static int searchInsert1(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }
}
