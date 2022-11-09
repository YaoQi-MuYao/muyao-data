package com.data.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 *
 * @author XiaoXiao
 * @Date 2022/11/9 22:55
 **/
public class Q3 {
    /***
     *给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
     *
     * 每次「迁移」操作将会引发下述活动：
     *
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     *
     * @author muyao
     * @date 2022/11/9 22:57
     * @param
     **/
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 3;
        List<List<Integer>> lists = shiftGrid(a, k);
        System.out.println(lists);
    }

    public static List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //展开到一维中
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp.add(grid[i][j]);
            }
        }
        //移动k次
        for (int i = 0; i < k; i++) {
            Integer remove = temp.remove(temp.size() - 1);
            temp.add(0, remove);
        }
        int i = 0;
        //封装结果
        while (i < temp.size()) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(temp.get(i));
                i++;
            }
            ans.add(row);
        }
        return ans;
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp.add(grid[i][j]);
            }
        }
        for (int i = 0; i < k; i++) {
            temp.add(0, temp.remove(temp.size() - 1));
        }
        for (int i = 0; i < temp.size(); ) {
            List<Integer> one = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                one.add(temp.get(i));
                i++;
            }
            result.add(one);
        }
        return result;
    }
}
