package com.hanzhanyi.leetcode.offer;

/**
 * Created by hanzhanyi on 2021/2/13.
 */
public class Problem21 {
    public int[] exchange(int[] nums) {
        int i = 0 ;
        int j= nums.length-1;
        while(i<=j&&i<nums.length){
            while(nums[i]%2==1){
                i++;
            }
            while(nums[j]%2==0){
                j--;
            }
            int temp  = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        new Problem21().exchange(new int[]{1,3,5});
    }
}
