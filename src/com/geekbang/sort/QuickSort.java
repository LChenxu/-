package com.geekbang.sort;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.sort
 * @date 2021/1/15 15:41
 * @example:
 * @Description:
 * 快排的思想是这样的：
 * 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
 * 我们遍历 p 到 r 之间的数据，
 * 将小于 pivot 的放到左边，将大于 pivot 的放到右边，
 * 将 pivot 放到中间。经过这一步骤之后，数组 p 到 r 之间的数据就被分成了三个部分，
 * 前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
 */
public class QuickSort {
    public static void quickSort(int[] a, int n) {
        if (n < 2){return;}
        quick(a, 0, n - 1);
    }

    /**
     * 原地排序
     * 不稳定排序
     * 平均O(nlogn)
     * @param a
     * @param low
     * @param high
     */
    private static void quick(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        // 归并排序的处理过程是由下到上的，先处理子问题，然后再合并。
        // 而快排正好相反，它的处理过程是由上到下的，先分区，然后再处理子问题
        int pivot = partition(a, low, high);
        // 分治pivot左右区间，pivot不用动因为这就是它排好序的位置
        quick(a, low, pivot - 1);
        quick(a, pivot + 1, high);
    }

    /**
     * 自上而下的分治，每次分治的partition方法都会将数据分成3个区间：
     *  第一个区间：随机一个数据，一般是最后一个值highValue
     *   第二个区间：小于highValue的数据都放到highValue左边
     *    第三个区间：大于highValue的数据都放到highValue右边
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] a, int low, int high) {
        //选一个随机值，当做区分左右两个区间的值
        int highValue = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            // 小于随机值的数据要插入到小于随机值区间的末尾，此处使用交换的思想数组不用移动数据
            if (a[j] < highValue) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        // 随机值插入正确的位置，该位置就是pivot
        a[high] = a[i];
        a[i] = highValue;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 4, 1, 2, 6};
        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
