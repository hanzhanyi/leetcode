package com.hanzhanyi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzhanyi on 2019/9/29.
 */
public class problem7 {
    public int reverse(int x) {
        if ((x >= -9 && x <= 0) || (x <= 9 && x > 0)) {
            return x;
        }
        int s;
        int dex;
        if (x >= 0) {
            s = x;
            dex = 1;
        } else {
            s = -x;
            dex = -1;
        }
        List<Integer> list = new ArrayList();
        while (s != 0) {
            //最后一位数字
            int number = s % 10;
            list.add(number);
            s = s / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer temp : list) {
            sb.append(temp);
        }
        try {
            return dex * new Integer(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("9646324351"));
//        new problem7().reverse(1534236469);

    }
}
