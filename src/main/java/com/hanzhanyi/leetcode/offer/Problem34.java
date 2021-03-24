package com.hanzhanyi.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanzhanyi on 2021/2/16.
 */
public class Problem34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList();
        }
        List<Integer> list = new ArrayList();
        List<List<Integer>> resultList = new ArrayList();
        sum(root, sum, 0, list, resultList);
        return resultList;
    }

    private void sum(TreeNode node, int sum, int now, List<Integer> list, List<List<Integer>> resultList) {
        if (node.val + now == sum && node.left == null && node.right == null) {
            list.add(node.val);
            resultList.add(new ArrayList(list));
            return;
        } else if (node.val + now != sum) {
            list.add(node.val);
            if (node.left != null) {
                sum(node.left, sum, node.val + now, new ArrayList(list), resultList);
            }
            if (node.right != null) {
                sum(node.right, sum, node.val + now, new ArrayList(list), resultList);
            }
        } else {
            return;
        }
    }


    public static void main(String[] args) {
        System.out.println((int)String.valueOf(45).charAt(1));
    }

}
