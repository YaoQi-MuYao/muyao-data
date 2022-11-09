package com.data.leetcode.question;

/**
 * 824. 山羊拉丁文
 * @author XiaoXiao
 * @Date 2022/11/9 22:53
 **/
public class Q2 {

    public static void main(String[] args) {
        String toGoatLatin = toGoatLatin("I speak Goat Latin");
        System.out.println(toGoatLatin);
    }

    public static String toGoatLatin(String sentence) {
        String[] sentenceArr = sentence.split(" ");
        int[] cnt = new int[57];
        String ans = "aeiouAEIOU";
        String ma = "ma";
        StringBuilder newSentence = new StringBuilder();
        char a = 'A';
        for (int i = 0; i < ans.length(); i++) {
            cnt[ans.charAt(i) - a]++;
        }
        for (int i = 0; i < sentenceArr.length; i++) {
            String sent = sentenceArr[i];
            StringBuilder newSent;
            /* 元音开头 */
            if (cnt[sent.charAt(0) - 'A'] == 1) {
                newSent = new StringBuilder(sent + ma);
            } else {
                newSent = new StringBuilder(sent.substring(1) + sent.substring(0, 1) + ma);
            }
            for (int j = 0; j < i + 1; j++) {
                newSent.append("a");
            }
            newSentence.append(newSent);
            if (i != sentenceArr.length - 1) {
                newSentence.append(" ");
            }
        }
        return newSentence.toString();
    }

    public static String toGoatLatin1(String s) {
        int n = s.length();
        String last = "a";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            if ("aeiouAEIOU".indexOf(s.charAt(i)) >= 0) {
                sb.append(s.substring(i, j)).append("ma");
            } else {
                sb.append(s.substring(i + 1, j)).append(s.charAt(i)).append("ma");
            }
            sb.append(last);
            last += "a";
            i = j + 1;
            if (i < n) sb.append(" ");
        }
        return sb.toString();
    }
}
