package com.geekbang.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.dynamicprogramming
 * @date 2021/1/18 17:23
 * @example:
 * @Description:硬币找零问题
 */
public class CoinChange {

    private static int coinChange(int k) {

        List<Integer> one = new ArrayList<>(10);
        one.add(1);
        one.add(2);
        one.add(5);
        one.add(10);
        one.add(20);
        one.add(50);
        one.add(100);

        if (k == 0) {
            return 0;
        } else if (one.contains(k)) {
            return 1;
        } else if (k == 3) {
            return 2;
        }

        int[] pros = new int[k + 1];
        pros[0] = 0;
        pros[1] = 1;
        pros[2] = 1;
        pros[3] = 2;
        pros[5] = 1;
        pros[10] = 1;
        pros[20] = 1;
        pros[50] = 1;
        pros[100] = 1;

        for (int i = 4; i <= k; i++) {
            if (one.contains(i)){
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; ++j) {
                int num = pros[j] + pros[i - j];
                if (num < min) {
                    min = num;
                }
            }
            pros[i] = min;
        }
        return pros[k];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(396));
    }
}
