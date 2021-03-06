package com.data.utils;

/**
 * @className: DataUtils
 * @author: muyao
 * @description: 可能使用的工具类
 * @date: 2022/6/14 11:35 AM
 * @version: 1.0
 */
public class DataUtils {

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
