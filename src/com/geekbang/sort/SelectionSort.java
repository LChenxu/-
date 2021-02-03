package com.geekbang.sort;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.sort
 * @date 2021/1/14 19:27
 * @example:
 * @Description:
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
 * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
 */
public class SelectionSort {
    /**
     * 1.原地排序
     * 2.不稳定
     * 3.时间复杂度都是O(n^2)
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a,int n) {
        if (n < 2) {return;}
        for (int i = 0; i < n; i++) {
            int min = a[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (min > a[j]) {
                    min = a[j];
                    index = j;
                }
            }
            a[index] = a[i];
            a[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        selectionSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
