package com.hanzhanyi.leetcode.offer;

/**
 * Created by hanzhanyi on 2021/2/13.
 */
public class Problem16 {
    public double myPow(double x, int n) {
        double result = 1;
        int[] num = new int[10];
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                result *= x;
            }
            return result;
        }
        if (n < 0) {
            for (int i = 1; i <= -n; i++) {
                result *= x;
            }
        }
        return 1 / result;
    }
}
