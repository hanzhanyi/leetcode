package com.hanzhanyi.leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzhanyi on 2021/1/10.
 */
public class problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList();
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int left = s.length(); left >= 0; left--) {
            for (int right = left; right < s.length(); right++) {
                if (s.charAt(left) == s.charAt(right) && (right - left < 2 || dp[left + 1][right - 1] == true)) {
                    dp[left][right] = true;
                }
            }
        }
        List<String> tempList = new ArrayList();
        search(s, list, 0, tempList, dp);
        return list;
    }

    private void search(String s, List<List<String>> list, int leftIndex, List<String> tempList, boolean dp[][]) {
        List<String> anotherList = new ArrayList(tempList);
        if (leftIndex == s.length()) {
            list.add(anotherList);
            return;
        }
        for (int i = leftIndex; i < s.length(); i++) {
            if (!dp[leftIndex][i]) {
                continue;
            }
            anotherList.add(s.substring(leftIndex, i + 1));
            search(s, list, i + 1, anotherList, dp);
            anotherList.remove(anotherList.size() - 1);
        }

    }

    public static void main(String[] args) {
        new problem131().partition("abbab");
    }
}
