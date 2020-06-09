package com.hanzhanyi.leetcode.DP;

/**
 * Created by hanzhanyi on 2019/9/20.
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class problem5 {


    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String maxStr = s.substring(0, 1);
        //初始化赋值
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        //进行dp遍历
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                    dp[i][j] = true;
                    maxStr = (j - i >= maxStr.length() ? s.substring(i, j + 1) : maxStr);
                } else if (s.charAt(i) == s.charAt(j) && j - i == 1) {
                    dp[i][j] = true;
                    maxStr = (j - i >= maxStr.length() ? s.substring(i, j + 1) : maxStr);
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(new problem5().longestPalindrome("ac"));
    }
}
