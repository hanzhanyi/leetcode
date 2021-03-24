package com.hanzhanyi.leetcode.offer;

/**
 * Created by hanzhanyi on 2021/2/13.
 * 此题注意n可能为负数，所以判断条件需为n!=0
 */
public class Problem15 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            if (((1 << i) & n) != 0) {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = (n >>> 1);
        }
        return count;
    }

}

