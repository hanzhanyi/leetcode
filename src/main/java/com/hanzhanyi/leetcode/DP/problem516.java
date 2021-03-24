package com.hanzhanyi.leetcode.DP;

/**
 * Created by hanzhanyi on 2021/1/11.
 */
public class problem516 {
    public int longestPalindromeSubseq(String s) {
        int dp[][]  = new int[s.length()][s.length()];
        for(int left=s.length()-1;left>=0;left--){
            for(int right = left ; right<s.length();right++){
                if(left-right==0){
                    dp[left][right]=1;
                }else if(s.charAt(left)==s.charAt(right)){
                    dp[left][right]= dp[left+1][right-1]+2;
                }else{
                    dp[left][right]= Math.max(dp[left+1][right],dp[left][right-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        new problem516().longestPalindromeSubseq("aa");
    }
}
