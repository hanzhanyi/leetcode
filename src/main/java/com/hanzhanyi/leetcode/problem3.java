package com.hanzhanyi.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hanzhanyi on 2019/9/19.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class problem3 {
    public int lengthOfLongestSubstring(String s) {
        Queue<String> queue = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int i = 0;
        for (char ch : chars) {
            if (queue.contains(String.valueOf(ch))) {
                while (true) {
                    String first = queue.poll();
                    if (String.valueOf(ch).equals(first)) {
                        break;
                    }
                }
                queue.offer(String.valueOf(ch));
            } else {
                queue.offer(String.valueOf(ch));
            }
            if (queue.size() > i) {
                i = queue.size();
            }
        }
        return i;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        new problem3().lengthOfLongestSubstring(s);
    }
}
