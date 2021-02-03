package com.geekbang.backtracking;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.backtracking
 * @date 2021/1/20 19:05
 * @example:
 * @Description:0-1背包问题
 * 我们有一个背包，背包总的承载重量是 Wkg。
 * 现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 */
public class BackTracking01knapsack {

    private static int maxW = Integer.MIN_VALUE;

    /**
     * 重点在于每个物品，只有放入背包和不放入背包两种状态，所以叫做0-1背包问题
     * 假设有3个物品，不管背包总重大小，这3个物品的遍历顺序是（当然正常情况下有剪枝的存在，大概率是不会遍历无效路径的）：
     * ① 0 0 0 update maxW
     * ② 0 0 1 update maxW
     * ③ 0 1 0 update maxW
     * ④ 0 1 1 update maxW
     * ⑤ 1 0 0 update maxW
     * ⑥ 1 0 1 update maxW
     * ⑦ 1 1 0 update maxW
     * ⑧ 1 1 1 update maxW
     * @param i 表示第i个物品
     * @param cw 表示目前累计放入背包的物品总重
     * @param items 表示物品对呀的重量数组
     * @param n 数组的大小
     * @param W 背包的总重 Wkg
     */
    private void f(int i, int cw, int[] items, int n, int W) {
        // 目前累计总重等于背包总重（cw == W） 或者 已经遍历完所有的物品（i == n），更新MaxWell大小并退出
        if (cw == W || i == n) {
            if (maxW < cw) {
                maxW = cw;
            }
            return;
        }
        // 这个递归表示0，即不放入背包
        f(i + 1, cw, items, n, W);
        // 搜索剪枝，剔除总和大于背包重量，这种是不需要放入背包的
        if (cw + items[i] <= W) {
            // 这个递归表示1，即放入背包
            f(i + 1, cw + items[i], items, n, W);
        }
    }
}
