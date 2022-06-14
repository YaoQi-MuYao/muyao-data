package com.data;

public class Main {
    public static void main(String[] args) {
        print(1024);
    }

    /**
     * 输出int32位二进制
     *
     * @param num 十进制数字
     * @author muyao
     * @date 2022/6/14 11:28 AM
     */
    public static void print(int num) {
        for (int i = 31; i > 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }
}