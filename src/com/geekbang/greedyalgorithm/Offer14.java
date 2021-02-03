package com.geekbang.greedyalgorithm;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.greedyalgorithm
 * @date 2021/1/17 20:34
 * @example:
 * @Description:和动态规划一样的问题，用贪心算法解决
 * 核心思想尽可能多的剪出长度为3的绳子，
 * 例外情况是长度为4的绳子，4分成2*2>1*3,所以长度为4的绳子要剪成[2,2]
 */
public class Offer14 {
    private static int greedyAlgorithm(int length) {

        // 绳子长度<=3我们可以很确定结果
        if (length < 2) {
            //因为题目要求必须剪一次，但是长度为0和1时是分不出整数长度的子问题的
            return 0;
        } else if (length == 2) {
            // 最优解其实是2，但是必须剪一次，只能分为两个1长度的绳子
            return 1;
        } else if (length == 3) {
            // 最优解其实是3，必须剪一次，最大的乘积就是1*2这种情况
            return 2;
        }
        //可以最多剪出多少个3长度的绳子
        int threeNum = length / 3;
        //最后是1的情况要保留出一个4长度的绳子
        if (length - threeNum * 3 == 1) {
            --threeNum;
        }
        // 剩下的长度可能是0、1、2、4，分别对应的最优解是0、1、2、4（2*2）
        // 0:前面的多个3的乘积就是最优解，2^(0/2)=1，1与Math.pow(3, threeNum)乘积就是结果
        // 1:需要用多个3的乘积再乘1，2^(1/2)=1，1与Math.pow(3, threeNum)乘积就是结果
        // 2:2^(2/2)=2
        // 4:2^(4/2)=4
        // 可以发现0、1、2、4长度对应的最优解可以用Math.pow(2, twoNum)表示
        int twoNum = (length - threeNum * 3) / 2;
//        return (int) Math.pow(3, threeNum) * (int) Math.pow(2, twoNum);
        long max = 1;
        for (int i = 0; i < threeNum; ++i) {
            max = max * 3 % 1000000007;
        }
        for (int i = 0; i < twoNum; ++i) {
            max = max * 2 % 1000000007;
        }
        return (int) max;
    }

    public static void main(String[] args) {
        System.out.println(greedyAlgorithm(120));
    }
}
