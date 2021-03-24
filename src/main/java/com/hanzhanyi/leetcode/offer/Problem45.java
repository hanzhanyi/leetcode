package com.hanzhanyi.leetcode.offer;

/**
 * Created by hanzhanyi on 2021/2/18.
 */
public class Problem45 {
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (compareTo(nums[j],middle) && i < j) {
                j--;
            }
            while (compareTo(middle, nums[i]) && i < j) {
                i++;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[start] = nums[j];
        nums[j] = middle;
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    /**
     * 5 8 3 2 1
     * * first>second时，返回true
     */
    private boolean compareTo(int first, int second) {
        int start = Integer.valueOf(String.valueOf(first) + String.valueOf(second));
        int end = Integer.valueOf(String.valueOf(second) + String.valueOf(first));
        if (start >= end) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] dp = new int[3][5];
        new Problem45().minNumber(new int[]{3,30,34,5,9});
    }
}
