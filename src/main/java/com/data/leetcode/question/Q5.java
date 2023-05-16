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
        String s = "pwwkew";
        int length = lengthOfLongestSubstring2(s);
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
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            /*不管是否更新left，都要更新 s.charAt(i) 的位置！*/
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
