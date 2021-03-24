package com.hanzhanyi.leetcode.DP;

/**
 * Created by hanzhanyi on 2021/1/11.
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 */
public class problem647 {
    public int countSubstrings(String s) {
        boolean dp[][]  = new boolean[s.length()][s.length()];
        int count = 0 ;

        //查询所有回文子串
        for(int left = s.length()-1; left>=0;left--){
            for(int right = left;right<s.length();right++){
                if( s.charAt(left) == s.charAt(right) && (right-left<2 || dp[left+1][right-1])){
                    dp[left][right] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
