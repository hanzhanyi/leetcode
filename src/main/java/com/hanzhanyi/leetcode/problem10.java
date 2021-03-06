package com.hanzhanyi.leetcode;

/**
 * TODO
 * Created by hanzhanyi on 2019/10/22.
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class problem10 {
    public boolean isMatch(String s, String p) {
        //原数组
        int oldIndex = 0;
        int regularIndex = 0;
        //正则表达式
        while (true) {
            if (regularIndex == p.length() && oldIndex == s.length()) {
                return true;
            } else if((regularIndex == p.length() || oldIndex == s.length())){
                return false;
            }
            char oldChar = s.charAt(oldIndex);
            if (regularIndex + 1 < p.length() && p.charAt(regularIndex + 1) == '*') {
                if (isMathc(oldChar, p.substring(regularIndex, regularIndex + 2))) {
                    //匹配成功，进行下一个字符的匹配
                    oldIndex++;
                    if (oldIndex == s.length()) {
                        regularIndex += 2;
                    }
                    continue;
                } else {
                    //匹配失败，下一个正则进行匹配
                    regularIndex += 2;
                    continue;
                }
            } else {
                if (isMathc(oldChar, p.substring(regularIndex, regularIndex + 1))) {
                    oldIndex++;
                    regularIndex++;
                    continue;
                } else {
                    regularIndex++;
                    continue;
                }
            }
        }
    }

    private boolean isMathc(char s, String regular) {
        if (regular.length() == 1) {
            if (regular.equals(String.valueOf(s)) || regular.equals(".")) {
                return true;
            } else {
                return false;
            }
        } else if (regular.length() == 2) {
            char first = regular.charAt(0);
            char second = regular.charAt(1);
            if ((first == '.' || s == first) && second == '*') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new problem10().isMatch("aaa", "a*a"));
    }
}
