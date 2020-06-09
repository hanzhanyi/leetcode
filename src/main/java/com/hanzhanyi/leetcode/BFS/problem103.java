package com.hanzhanyi.leetcode.BFS;

import java.util.*;

/**
 * Created by hanzhanyi on 2020/5/12.
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class problem103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        if (root == null) {
            return result;
        }
        stack.push(root);
        boolean isrev = true;
        while (!stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Stack<TreeNode> stacknew = new Stack();
            if (isrev) {
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = stack.pop();
                    temp.add(poll.val);
                    if (poll.left != null) {
                        stacknew.push(poll.left);
                    }
                    if (poll.right != null) {
                        stacknew.push(poll.right);
                    }
                }
                result.add(temp);
                isrev = false;
            } else {
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = stack.pop();
                    temp.add(poll.val);
                    if (poll.right != null) {
                        stacknew.push(poll.right);
                    }
                    if (poll.left != null) {
                        stacknew.push(poll.left);
                    }
                }
                result.add(temp);
                isrev = true;
            }
            stack = stacknew;
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
