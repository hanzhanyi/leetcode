package com.hanzhanyi.leetcode.DP;

/**
 * Created by hanzhanyi on 2020/6/8.
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 *
 * <p>
 * <p>
 * 输入:
 * ["1","0","1","0"],
 * ["1","0","1","1"],
 * ["1","0","1","1"],
 * ["1","1","1","1"]
 * 输出
 * 9
 * 预期结果
 * 4
 */
public class problem221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = dp[i][0] > max ? dp[i][0] : max;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = dp[0][i] > max ? dp[0][i] : max;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                    max = dp[i][j] > max ? dp[i][j] : max;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] ch = new char[4][4];
        ch[0] = new char[]{'1', '0', '1', '0'};
        ch[1] = new char[]{'1', '0', '1', '1'};
        ch[2] = new char[]{'1', '0', '1', '1'};
        ch[3] = new char[]{'1', '1', '1', '1'};
        new problem221().maximalSquare(ch);
    }
}
