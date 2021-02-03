package com.geekbang.dynamicprogramming;

import com.sun.org.apache.regexp.internal.RE;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.dynamicprogramming
 * @date 2021/1/21 19:06
 * @example:
 * @Description: 动态规划解决0-1背包问题
 */
public class Dynamic01knapsack {
    /**
     * 动态规划其实是以空间换时间的思想，这个方法多出了一个boolean[][] result数组的额外空间
     * @param items 物品重量列表
     * @param n 物品个数
     * @param w 背包总重
     * @return 能放入背包的最大重量
     */
    private int knapsack(int[] items, int n, int w) {
        boolean[][] result = new boolean[n][w + 1];
        result[0][0] = true;
        if (items[0] <= w) {
            result[0][items[0]] = true;
        }
        // i表示第几个物品
        for (int i = 1; i < n; ++i) {
            // 先当前物品看不放入背包的情况
            for (int j = 0; j <= w; ++j) {
                if (result[i - 1][j]) {
                    result[i][j] = result[i - 1][j];
                }
            }
            // 然后要放入背包的情况
            for (int j = 0; j <= w - items[i]; ++j) {
                if (result[i - 1][j]) {
                    result[i][j + items[i]] = true;
                }
            }
        }

        for (int k = w; k >= 0; --k) {
            // 所有决策都走完，只需要变量最后一行就能知道放入背包的最大重量
            if (result[n - 1][k]) {
                return k;
            }
        }
        return -1;
    }

    /**
     * 使用一维数组，减少空间开销
     * @param items
     * @param n
     * @param w
     * @return
     */
    private int knapsack2(int[] items, int n, int w) {
        boolean[] result = new boolean[w + 1];
        result[0] = true;
        if (items[0] <= w) {
            result[items[0]] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = w - items[i]; j >= 0; --j) {
                if (result[j]) {
                    result[j + items[i]] = true;
                }
            }
        }

        for (int k = w; k >= 0; --k) {
            // 所有决策都走完，只需要变量最后一行就能知道放入背包的最大重量
            if (result[k]) {
                return k;
            }
        }
        return -1;
    }


}
