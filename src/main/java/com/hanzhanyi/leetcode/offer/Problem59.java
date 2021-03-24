package com.hanzhanyi.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by hanzhanyi on 2021/2/20.
 */
public class Problem59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int left = 1-k;
        int right = 0 ;
        while(right<nums.length){
            if(left>0&&deque.peekFirst()==nums[left-1]){
                deque.removeFirst();
            }
            while(!deque.isEmpty()&&deque.peekLast()<nums[right]){
                deque.removeLast();
            }
            deque.addLast(nums[right]);
            if(left >= 0)
                res[left] = deque.peekFirst();  // 记录窗口最大值
            left++;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Problem59().maxSlidingWindow(new int[]{1,-1},1);
    }
}
