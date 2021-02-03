package com.geekbang.dynamicprogramming;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.dynamicprogramming
 * @date 2021/1/17 20:01
 * @example:
 * @Description:
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Offer14 {
    private static int dynamicProgramming(int length) {
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
        // 数组中存储了f(index)的最优解,index为0、1、2、3的最优解就是不剪，
        // 也就是说8长度，分为2、3、3之后就相乘结果18就是最优的，再细分就小于18了
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        //开始求length>=4之后的所有f(i)的最优解，从下往上直到算出f(length)=max(f(i)*f(length-i))
        for (int i = 4; i <= length; ++i) {
            int median = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int res = products[j] * products[i - j];
                if (median < res) {
                    median = res;
                }
            }
            products[i] = median;
        }
        return products[length];
    }

    public static void main(String[] args) {
        System.out.println(dynamicProgramming(120));
    }
}
