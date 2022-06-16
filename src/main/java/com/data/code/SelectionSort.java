package com.data.code;

/**
 * 三个拉胯基础排序
 *
 * @author XiaoXiao
 * @Date 2022/6/14 22:09
 **/
public class SelectionSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 选择排序
     *
     * @param arr 无序数组
     * @author muyao
     * @date 2022/6/14 22:28
     **/
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 无序数组
     * @author muyao
     * @date 2022/6/14 22:29
     **/
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            for (int second = 1; second < end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /***
     * 插入排序
     *
     * @author muyao
     * @date 2022/6/15 18:07
     * @param arr 无序数组
     **/
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    /***
     * 插入排序 优化方法
     *
     * @author muyao
     * @date 2022/6/15 18:07
     * @param arr 无序数组
     **/
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end - 1; pre > 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 8, 7, 3, 4, 2, 5, 7, 3, 1, 8, 9, 1};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
