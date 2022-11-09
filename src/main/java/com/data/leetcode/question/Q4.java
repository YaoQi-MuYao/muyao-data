package com.data.leetcode.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1781. 所有子字符串美丽值之和
 *
 * @author XiaoXiao
 * @Date 2022/11/9 22:58
 **/
public class Q4 {

    /***
     *一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
     *
     * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
     * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sum-of-beauty-of-all-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @author muyao
     * @date 2022/11/9 22:59
     **/
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int res = beautySum1("aabcb");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(res);

    }

    public static int beautySum(String s) {
        long start = System.currentTimeMillis();
        Integer result = 0;
        if (s.length() <= 3) {
            char[] array = s.toCharArray();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            return getOne(array);
        } else {
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 2; j < s.length(); j++) {
                    String substring = s.substring(i, j + 1);
                    char[] array = substring.toCharArray();
                    int one = getOne(array);
                    result += one;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            return result;
        }
    }

    public static int getOne(char[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < array.length; n++) {
            int ch = (int) array[n];
            if (map.size() == 0) {
                map.put(ch, 1);
            } else {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
        }
        List<Integer> sort = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sort.add(entry.getValue());
        }
        sort.sort(Integer::compare);
        return sort.get(sort.size() - 1) - sort.get(0);
    }

    public static int beautySum1(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); ++j) {
                char ch = s.charAt(j);
                count[ch - 'a'] += 1;
                int max_value = Integer.MIN_VALUE;
                int min_value = Integer.MAX_VALUE;
                for (Integer value : count) {
                    if (value > 0 && value > max_value) {
                        max_value = value;
                    }
                    if (value > 0 && value < min_value) {
                        min_value = value;
                    }
                }
                ans += (max_value - min_value);
            }
        }
        return ans;
    }
}
