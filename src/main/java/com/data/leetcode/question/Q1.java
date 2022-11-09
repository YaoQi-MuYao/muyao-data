package com.data.leetcode.question;

/**
 * 1684. 统计一致字符串的数目
 * @author XiaoXiao
 * @Date 2022/11/9 22:45
 **/
public class Q1 {

    public static void main(String[] args) {
        String[] words = {"ad","bd","aaab","baa","badab"};
        int ab = countConsistentStrings2("ab", words);
        System.out.println(ab);
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        char[] allowedChars = allowed.toCharArray();
        for (String word : words) {
            char[] wordChars = word.toCharArray();
            boolean a = true;
            boolean b = true;
            for (int i = 0; i < wordChars.length && a; i++) {
                for (int j = 0; j < allowedChars.length && b; j++) {
                    if (wordChars[i] == allowedChars[j]) {
                        break;
                    } else {
                        if ( j == allowedChars.length -1 ) {
                            a = false;
                            b = false;
                        }
                    }
                }
            }
            if (a) {
                count++;
                System.out.println(word);
            }
        }
        return count;
    }

    public static int countConsistentStrings1(String all, String[] words) {
        int ans = 0, mask = 0;
        for (int i = 0; i < all.length(); i++) {
            mask |= (1 << (all.charAt(i) - 'a'));
        }
        for (String word: words) {
            int tem = 0;
            for (int i = 0; i < word.length(); i++) {
                tem |= (1 << (word.charAt(i) - 'a'));
            }
            if ((tem | mask) == mask) ans++;
        }
        return ans;
    }

    public static int countConsistentStrings2(String all, String[] words) {
        int[] cnt = new int[26];
        int ans = 0;
        for (int i = 0; i < all.length(); i++)  {
            cnt[all.charAt(i) - 'a']++;
        }
        for (String word: words) {
            ans++;
            for (int i = 0; i < word.length(); i++) {
                if (cnt[word.charAt(i) - 'a'] == 0) {
                    ans--; break;
                }
            }
        }
        return ans;
    }
}
