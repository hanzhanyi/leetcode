package com.hanzhanyi.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hanzhanyi on 2021/2/20.
 */
public class Problem57 {
    public int[][] findContinuousSequence(int target) {
        int[] nums = new int[target];
        for (int i = 0; i < target; i++) {
            nums[i] = i+1;
        }
        int left = 0;
        int right = 0;
        List<int[]> res = new ArrayList<>();
        int sum = nums[right];
        while (left < target && right < target) {
            while (right < target - 1 && sum < target) {
                right++;
                sum += nums[right];
            }
            while (left < target && sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                int[] ans = new int[right - left + 1];
                for (int k = left; k <= right; k++)
                    ans[k - left] = nums[k];
                if (left < right) {
                    res.add(ans);
                }
                sum -= nums[left];
                left++;
            }
        }
        Stack stack = new Stack();
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        new Problem57().findContinuousSequence(9);
    }
}
