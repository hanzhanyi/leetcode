package com.hanzhanyi.leetcode.DP;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>();
        dp.add(triangle.get(0).get(0));
        Integer min = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> newDp = new ArrayList<>();
            List<Integer> integers = triangle.get(i);
            for (int j = 0; j < integers.size(); j++) {
                Integer temp = 0;
                if (j - 1 >= 0 && j < dp.size()) {
                    temp = Math.min(dp.get(j - 1), dp.get(j)) + integers.get(j);
                } else if (j - 1 >= 0 && j >= dp.size()) {
                    temp = dp.get(j - 1) + integers.get(j);
                } else if (j - 1 < 0 && j < dp.size()) {
                    temp = dp.get(j) + integers.get(j);
                }
                newDp.add(temp);
            }
            dp = newDp;
            if (i == triangle.size() - 1) {
                min = newDp.get(0);
                for (int j = 0; j < newDp.size(); j++) {
                    min = Math.min(min, newDp.get(j));
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List list = Lists.newArrayList();
        List list1 = Lists.newArrayList();
        list1.add(-10);
//        List list2 = Lists.newArrayList();
//        list2.add(3);
//        list2.add(4);
//        List list3 = Lists.newArrayList();
//        list3.add(6);
//        list3.add(5);
//        list3.add(7);
//        List list4 = Lists.newArrayList();
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);
        list.add(list1);
//        list.add(list2);
//        list.add(list3);
//        list.add(list4);
        new problem120().minimumTotal(list);
    }
}
