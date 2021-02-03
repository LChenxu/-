package com.geekbang.divideandconquer;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.divideandconquer
 * @date 2021/1/19 15:29
 * @example:
 * @Description:
 * 使用分治思想统计一个数组的逆序度，使用了归并排序的实现方式
 */
public class Divide {

    private static int count;

    private static int mergeSort(int[] a, int n) {
        count = 0;
        sort(a, 0, n - 1);
        return count;
    }

    private static void sort(int[] a, int low, int high) {
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

    private static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
                // 统计a[mid]到a[i]之间大于a[j]的数字
                count+=(mid-i)+1;
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

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 1, 5, 6};
        System.out.println(mergeSort(a, 6));
    }
}
