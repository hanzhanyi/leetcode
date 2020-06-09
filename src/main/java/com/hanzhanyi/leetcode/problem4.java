package com.hanzhanyi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzhanyi on 2019/9/20.
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int length = nums1.length + nums2.length;
        List<Integer> arrayList = new ArrayList();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arrayList.add(nums1[i]);
                i++;
            } else {
                arrayList.add(nums2[j]);
                j++;
            }
            if (arrayList.size() >= (length / 2 + 1)) {
                return check(length, arrayList);
            }
        }
        if (whilecheck(nums1, i, length, arrayList)) return check(length, arrayList);
        if (whilecheck(nums2, j, length, arrayList)) return check(length, arrayList);
        return check(length, arrayList);
    }

    private boolean whilecheck(int[] nums1, int i, int length, List<Integer> arrayList) {
        while (i < nums1.length) {
            arrayList.add(nums1[i]);
            i++;
            if (arrayList.size() >= (length / 2 + 1)) {
                return true;
            }
        }
        return false;
    }

    private double check(int length, List<Integer> arrayList) {
        if (length % 2 == 0) {
            int start = length / 2;
            int end = length / 2 + 1;
            return (arrayList.get(start - 1) + arrayList.get(end - 1)) / 2D;
        } else {
            int start = length / 2 + 1;
            return arrayList.get(start - 1);
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,3};
        int[] num2 = new int[]{2};
        new problem4().findMedianSortedArrays(num1, num2);
    }
}
