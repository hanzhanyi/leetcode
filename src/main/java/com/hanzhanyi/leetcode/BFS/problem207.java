package com.hanzhanyi.leetcode.BFS;

import java.util.*;

/**
 * Created by hanzhanyi on 2020/5/21.
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * <p>
 * 4
 * [[2,0],[1,0],[3,1],[3,2],[1,3]]
 * <p>
 * 8
 * [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5]]
 * 8
 * [[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]
 */
public class problem207 {
    public static void main(String[] args) {
//        int[][] a = new int[6][2];
//        a[0][0] = 1;
//        a[0][1] = 0;
//        a[1][0] = 2;
//        a[1][1] = 6;
//        a[2][0] = 1;
//        a[2][1] = 7;
//        a[3][0] = 6;
//        a[3][1] = 4;
//        a[4][0] = 7;
//        a[4][1] = 0;
//        a[5][0] = 0;
//        a[5][1] = 5;

        int[][] a = new int[2][2];
        a[0][0] = 1;
        a[0][1] = 0;
        a[1][0] = 2;
        a[1][1] = 0;

        new problem207().canFinish(3, a);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        //代表了边 出度的边
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        Map<Integer, Integer> duMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int numberLength = prerequisites.length;
        for (int i = 0; i < numberLength; i++) {
            List<Integer> orDefault = hashMap.getOrDefault(prerequisites[i][0], new ArrayList());
            orDefault.add(prerequisites[i][1]);
            hashMap.put(prerequisites[i][0], orDefault);
            duMap.put(prerequisites[i][1], duMap.getOrDefault(prerequisites[i][1], 0) + 1);
        }
        for (int i = 0; i < numCourses; i++) {
            if (duMap.getOrDefault(i, 0) == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Integer poll = queue.poll();
                numCourses--;
                List<Integer> list = hashMap.getOrDefault(poll, new ArrayList<>());
                if (list.isEmpty()) {
                    continue;
                }
                for (Integer add : list) {
                    Integer integer = duMap.get(add) - 1;
                    duMap.put(add, integer);
                    if (integer == 0) {
                        queue.add(add);
                    }
                }
                hashMap.remove(poll);
            }
        }
        if (numCourses == 0) {
            return true;
        }
        return false;
    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];
            List<List<Integer>> adjacency = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++)
                adjacency.add(new ArrayList<>());
            // Get the indegree and adjacency of every course.
            for (int[] cp : prerequisites) {
                indegrees[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }
            // Get all the courses with the indegree of 0.
            for (int i = 0; i < numCourses; i++)
                if (indegrees[i] == 0) queue.add(i);
            // BFS TopSort.
            while (!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for (int cur : adjacency.get(pre))
                    if (--indegrees[cur] == 0) queue.add(cur);
            }
            return numCourses == 0;
        }
    }

}
