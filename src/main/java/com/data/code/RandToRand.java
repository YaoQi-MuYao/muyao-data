package com.data.code;

/**
 * @author XiaoXiao
 * @Date 2022/6/15 19:34
 **/
public class RandToRand {

    /**
     * 给定一个随机函数 等概率返回 整数1~5（不可修改）
     *
     * @author muyao
     * @date 2022/6/15 19:36
     **/
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 随机机制 只能用f2
     * 等概率返回 0~1
     *
     * @param
     * @author muyao
     * @date 2022/6/15 19:39
     **/
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 返回000~111 做等概率 0~7等概率返回一个
     *
     * @author muyao
     * @date 2022/6/15 20:04
     **/
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    public static int g() {
        return f4() + 1;
    }

    /**
     * 给定 等概率生成 1~5函数f() ,求等概率1~7函数
     *
     * @author muyao
     * @date 2022/6/15 20:15
     **/
    public static void main(String[] args) {
        int timeTest = 1000000;
        int[] counts;
        counts = new int[8];
        for (int i = 0; i < timeTest; i++) {
            int num = y();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数，出现了" + counts[i] + "次");
        }
    }

    /**
     * 给定不等概率函数返回0 1 求等概率随机函数返回0 1
     *
     * @author muyao
     * @date 2022/6/15 20:24
     **/
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 等概率返回0和1
     *
     * @author muyao
     * @date 2022/6/15 20:26
     **/
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }
}
