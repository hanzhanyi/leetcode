package com.hanzhanyi.leetcode.DP;

/**
 * Created by hanzhanyi on 2020/9/9.
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * 通过次数84,066提交次数121,626
 */
public class problem96 {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += (dp[j - 1] * dp[i - j]);
            }
            dp[i] = sum;
        }
        return  dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new problem96().numTrees(4));
    }
}
