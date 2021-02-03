package com.geekbang.sort;

import java.util.Arrays;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.sort
 * @date 2021/1/14 20:34
 * @example:
 * @Description:
 * 如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
 */
public class MergeSort {

    /**
     * 1.这个合并方法中使用了一个tmp临时数组，所以归并排序不是原地排序，，因为任一时刻CPU只使用了一个tmp，所以空间复杂度是O(n)
     * 2.稳定排序，是否是稳定排序的关键是这个合并方法，只要保证low到mid的数据先放到tmp中，这就是一个稳定排序
     * 3.最好最坏平均时间复杂度都是O(nlogn)
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= high) {
            tmp[k++] = a[j++];
        }
        for (int x = 0; x < tmp.length; x++) {
            a[x + low] = tmp[x];
        }
    }

    public static void mergeSort(int[] a, int n) {
        sort(a, 0, n - 1);
    }

    public static void sort(int[] a, int low, int high) {
        // 递归终止条件
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        // 分的是数据的下标，数组本身不会变化
        sort(a, low, mid);
        sort(a, mid + 1, high);
        // 合并，合并下标范围内的两个数组，合并到一个临时数组中，然后用临时数组数据依次替换数组a下标low 到 high的数据
        merge(a, low, mid, high);
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        mergeSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
