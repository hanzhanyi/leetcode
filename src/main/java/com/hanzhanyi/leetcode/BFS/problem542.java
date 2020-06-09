package com.hanzhanyi.leetcode.BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by hanzhanyi on 2020/5/25.
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 输入:
 * [[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]
 * 输出
 * [[0,1,0],[0,2,0],[0,2,0],[0,2,0],[0,2,0]]
 * 预期结果
 * [[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]
 */
public class problem542 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    matrix[i][j] = -1;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int poll_i = poll[0];
                int poll_j = poll[1];
                result[poll_i][poll_j] = index;
                if (poll_i - 1 >= 0 && matrix[poll_i - 1][poll_j] != -1) {
                    matrix[poll_i - 1][poll_j] = -1;
                    queue.add(new int[]{poll_i - 1, poll_j});
                }
                if (poll_i + 1 < matrix.length && matrix[poll_i + 1][poll_j] != -1) {
                    matrix[poll_i + 1][poll_j] = -1;
                    queue.add(new int[]{poll_i + 1, poll_j});
                }
                if (poll_j - 1 >= 0 && matrix[poll_i][poll_j - 1] != -1) {
                    matrix[poll_i][poll_j - 1] = -1;
                    queue.add(new int[]{poll_i, poll_j - 1});
                }
                if (poll_j + 1 < matrix[0].length && matrix[poll_i][poll_j + 1] != -1) {
                    matrix[poll_i][poll_j + 1] = -1;
                    queue.add(new int[]{poll_i, poll_j + 1});
                }
            }
            index++;
        }
        return result;
    }

}
