package com.hanzhanyi.leetcode.offer;

/**
 * Created by hanzhanyi on 2021/1/18.
 */
public class Problem14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        if(n==2){
            return 1;
        }
        dp[1] = 1 ;
        dp[2] = 1 ;
        for(int i = 2 ; i<=n;i++){
            int sum = i-1;
            for(int j = 1 ;j<i;j++){
                sum =Math.max(sum,dp[j]*(i-j)%1000000007);
            }
            dp[i]=sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Problem14().cuttingRope(4);
    }

    // 1 1
    // 2 1*1
    // 3 1*2
    // 4 2*2
    // 5 2*3
    // 6 3*3
    // 7 2*2*3
    // 8 3*3*2
    // 9 3 3 3
    //10 3 3 2 2
}
