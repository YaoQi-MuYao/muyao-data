package com.data.leetcode.question;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: Q10
 * @author: muyao
 * @description:
 * @date: 2022/11/12 7:01 PM
 * @version: 1.0
 */
public class Q10 {

    public static void main(String[] args) {
        String s = "(";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        int index = 0;
        if (s.length()%2 == 1) {
            index = s.length()%2 + 1;
        } else {
            index = s.length()/2 - 1;
        }

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (map.containsKey(c)) {
                if (i + 1< array.length && map.get(c).equals(array[i + 1])) {
                    i++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
