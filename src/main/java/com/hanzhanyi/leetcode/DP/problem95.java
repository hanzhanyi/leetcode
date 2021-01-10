package com.hanzhanyi.leetcode.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzhanyi on 2020/9/15.
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class problem95 {

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            List<TreeNode> treeNodeNext = getTreeNodeNext(1, n);
            return treeNodeNext;
        }

        public List<TreeNode> getTreeNodeNext(int start, int end) {
            List<TreeNode> result = new ArrayList<>();
            if (end < start) {
                result.add(null);
                return result;
            }
            if (end == start) {
                result.add(new TreeNode(start));
                return result;
            }
            for (int i = start; i <= end; i++) {
                int left_start = start;
                int left_end = i - 1;
                int right_start = i + 1;
                int right_end = end;
                List<TreeNode> leftTreeNodes = getTreeNodeNext(left_start, left_end);
                List<TreeNode> rightTreeNodes = getTreeNodeNext(right_start, right_end);
                for (TreeNode left : leftTreeNodes) {
                    for (TreeNode right : rightTreeNodes) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = left;
                        treeNode.right = right;
                        result.add(treeNode);
                    }
                }
            }
            return result;
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
