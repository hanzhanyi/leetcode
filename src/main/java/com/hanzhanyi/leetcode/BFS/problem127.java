package com.hanzhanyi.leetcode.BFS;

import java.util.*;

/**
 * Created by hanzhanyi on 2020/5/20.
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class problem127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjacencyList = new HashMap<>();
        for (String oridiny : wordList) {
            for (int i = 0; i < oridiny.length(); i++) {
                String key = oridiny.substring(0, i) + '*' + oridiny.substring(i + 1, oridiny.length());
                List<String> orDefault = adjacencyList.getOrDefault(key, new ArrayList<>());
                orDefault.add(oridiny);
                adjacencyList.put(key, orDefault);
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int index = 0;
        while (!queue.isEmpty()) {
            index++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < poll.length(); j++) {
                    if (poll.equals(endWord)) {
                        return index;
                    }
                    String key = poll.substring(0, j) + '*' + poll.substring(j + 1, poll.length());
                    List<String> strings = adjacencyList.get(key);
                    if (strings != null && !strings.isEmpty()) {
                        strings.forEach(s -> queue.add(s));
                    }
                    adjacencyList.remove(key);
                }
            }
        }
        return 0;
    }
}
