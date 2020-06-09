package com.hanzhanyi.leetcode;

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
        if(s.length()==0){
            return s;
        }
        char[] chars = s.toCharArray();
        boolean py[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            py[i][i] = true;
        }
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j] && (i - j == 1 || py[j + 1][i - 1] == true)) {
                    py[j][i] = true;
                    if (i - j > end - start) {
                        start = j;
                        end = i;
                    }
                    continue;
                } else {
                    py[j][i] = false;
                }
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(new problem5().longestPalindrome("a"));
    }
}
