package com.hanzhanyi.leetcode.offer;

/**
 * Created by hanzhanyi on 2021/2/16.
 */
public class Problem33 {
    public boolean verifyPostorder(int[] postorder) {
        return isLastSearch(postorder, 0, postorder.length - 1);
    }

    private boolean isLastSearch(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int low = start;
        int high = end - 1;
        while (postorder[low] < postorder[end] && low < end) {
            low++;
        }
        while (postorder[high] > postorder[end] && high > 0) {
            high--;
        }

        return ((low==0&&high==0)||low == (high + 1)) && isLastSearch(postorder, start, high) && isLastSearch(postorder, low, end - 1);
    }

    public static void main(String[] args) {
        new Problem33().verifyPostorder(new int[]{5, 4, 3, 2, 1});
    }
}
