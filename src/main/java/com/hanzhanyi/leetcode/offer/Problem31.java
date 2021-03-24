package com.hanzhanyi.leetcode.offer;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hanzhanyi on 2021/2/16.
 */
public class Problem31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int lastIndex = 0;
        for (int i = 0; i < popped.length; i++) {
            for (int j = 0; j < pushed.length; j++) {
                if (popped[i] == pushed[j]) {
                    int count = 0;
                    for (int k = lastIndex - 1; k > j; k--) {
                        if (pushed[k] >= 0) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        return false;
                    }
                    lastIndex = j;
                    pushed[j] = -1;
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Problem31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
    }
}
