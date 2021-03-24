package com.hanzhanyi.leetcode.offer;

/**
 * Created by hanzhanyi on 2021/1/16.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Problem7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right || in_left > in_right) {
            return null;
        }
        if (pre_left == pre_right) {
            return new TreeNode(preorder[pre_left]);
        }
        int middle = preorder[pre_left];
        for (int i = 1; i <= (in_right - in_left + 1); i++) {
            if (middle == inorder[in_left + i + 1]) {
                TreeNode node = new TreeNode(middle);
                node.left = build(preorder, inorder, pre_left + 1, pre_left + 1 + i, in_left, in_left + i - 1);
                node.right = build(preorder, inorder, pre_left + i + 2, pre_right, in_left + i + 1, in_right);
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 20, 15, 7};
        int[] b = new int[]{9, 3, 15, 20, 7};
        new Problem7().buildTree(a, b);
    }
}
