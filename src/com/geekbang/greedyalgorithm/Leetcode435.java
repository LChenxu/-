package com.geekbang.greedyalgorithm;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.greedyalgorithm
 * @date 2021/1/18 19:38
 * @example:
 * @Description:无重复区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */
public class Leetcode435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        } else if (intervals.length == 1) {
            return 0;
        }

        // 找到所有区间中的最大值和最小值
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            min = Math.min(intervals[i][0], min);
            max = Math.max(intervals[i][1], max);
        }
        int count = 0;
        for (int j = min; j < max; ) {
            int minRight = max;
            boolean flag = false;
            //找到右区间最小的那一个，记录数量和右区间大小
            for (int i = 0; i < intervals.length; ++i) {
                if (intervals[i][0] >= j && intervals[i][1] <= minRight) {
                    minRight = intervals[i][1];
                    flag = true;
                }
            }
            // flag==false说明，已经没有左区间大于等于上一次选出的最小右区间了，可以退出循环了
            if (!flag){break;}
            count++;
            j = minRight;
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] in = {{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(in));
    }
}
