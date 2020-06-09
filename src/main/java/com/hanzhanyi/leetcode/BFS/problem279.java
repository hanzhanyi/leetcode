package com.hanzhanyi.leetcode.BFS;

/**
 * Created by hanzhanyi on 2020/5/12.
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 通过次数58,123提交次数103,746
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * dp[i] = Min(dp[i]+ dp[i-k*k]+1)
 */
public class problem279 {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            dp[i] = i;
            while (i >= j * j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new problem279().numSquares(13));
    }
}
