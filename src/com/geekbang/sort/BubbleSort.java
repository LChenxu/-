package com.geekbang.sort;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.sort
 * @date 2021/1/14 15:22
 * @example:
 * @Description:冒泡排序算法:思想就是一趟一趟的让最大值上浮
 */
public class BubbleSort {
    /**
     * 1.原地排序，空间复杂度O(1)
     * 2.相同值无交换-稳定排序
     * 3.最好时间复杂度O(n),最坏时间复杂度O(n^2)，平均O(n^2)
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n < 2) {return;}
        for (int j = 0; j < n; j++) {
            boolean flag = false;
            // n-j-1：n-1因为是 a[i] = a[i + 1]，所以i不用到n,
            // 再减去j是因为前面的几趟排序之后，n-j到n的数据已经是有序了，不用比较了
            for (int i = 0; i < n - j - 1; i++) {
                //比较、交换
                if (a[i] > a[i+1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    flag = true;
                }
            }
            //提前退出
            if (!flag) {break;}
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        bubbleSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
