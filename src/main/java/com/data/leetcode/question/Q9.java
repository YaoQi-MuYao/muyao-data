package com.data.leetcode.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 14最长公共前缀
 *
 * @className: Q9
 * @author: muyao
 * @description:
 * @date: 2022/11/11 1:25 AM
 * @version: 1.0
 */
public class Q9 {

    public static void main(String[] args) {
//        String[] s = {"flower","flow","flight"};
        String[] s = {"flower","flower","flower","flower"};
        String prefix = longestCommonPrefix(s);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int strLen = strs[0].length();
        int strIndex = 0;
        for (int i = 0; i < strLen; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < strIndex) {
                    return sb.substring(0, i);
                }
                if (0 == j) {
                    sb.append(strs[j].charAt(strIndex));
                    strIndex++;
                } else {
                    if (!strs[j].substring(0, i + 1).equals(sb.toString())){
                        return sb.substring(0, i);
                    }
                }
            }
        }
        return sb.toString();
    }
}
