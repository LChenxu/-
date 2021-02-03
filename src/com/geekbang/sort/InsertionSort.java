package com.geekbang.sort;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.sort
 * @date 2021/1/14 16:52
 * @example:
 * @Description:
 * 插入排序：我们将数组中的数据分为两个区间，已排序区间和未排序区间。
 * 初始已排序区间只有一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，
 * 并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
 */
public class InsertionSort {
    /**
     * 1.原地排序
     * 2.稳定排序
     * 3.O(n^2)
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n < 2) {return;}
        for (int i = 1; i < n; i++) {
            // 第一个值当做有序集合，第二个值开始是无序集合
            int current = a[i];
            //从有序集合的最后开始，从后往前查找大于当前无序集合的第一个元素的值
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > current) {
                    // 大于当前元素后移
                    a[j + 1] = a[j];
                } else {
                    // 找到不大于当前元素的位置，退出
                    break;
                }
            }
            // 插入位置
            a[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        insertionSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
