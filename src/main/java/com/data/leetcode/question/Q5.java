package com.data.leetcode.question;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * @author XiaoXiao
 * @Date 2022/11/9 23:01
 **/
public class Q5 {

    /***
      * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
      * @author muyao
      * @date 2022/11/9 23:39
      * @param
      **/
    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put((int) s.charAt(i), 0);
            int max1 = map.size();
            boolean a = true;
            for (int j = 1 + i; j < s.length() & a; j++) {
                if (map.containsKey((int) s.charAt(j))) {
                    a = false;
                    break;
                } else {
                    map.put((int) s.charAt(j), 0);
                }
                max1 = map.size();
                max = Math.max(max1, max);
            }
        }
        return max;
    }


    /***
      * 移动队列
      * @author muyao
      * @date 2022/11/9 23:41
      * @param s 给定字符串
      **/
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
}
