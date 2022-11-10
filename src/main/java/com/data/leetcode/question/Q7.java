package com.data.leetcode.question;

/**
 * 9 回文数
 * @className: Q7
 * @author: muyao
 * @description:
 * @date: 2022/11/10 12:40 PM
 * @version: 1.0
 */
public class Q7 {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * @param x 给定数字
     * @author muyao
     * @date 2022/11/10 1:10 PM
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }
}
