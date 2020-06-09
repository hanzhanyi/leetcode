package com.hanzhanyi.leetcode;

import java.util.ArrayList;

/**
 * Created by hanzhanyi on 2019/9/18.
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> list = new ArrayList();
        while (l1 != null && l2 != null) {
            list.add(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + j);
            if (list.get(i) >= 10) {
                list.set(i, list.get(i) - 10);
                j = 1;
            } else {
                j = 0;
            }
            if (i == list.size() - 1 && j == 1) {
                list.add(1);
                break;
            }
        }
        ListNode pre = null;
        ListNode head = null;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                ListNode ln = new ListNode(list.get(i));
                pre = ln;
                head = ln;
            } else {
                ListNode ln = new ListNode(list.get(i));
                pre.next = ln;
                pre = ln;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        new problem2().addTwoNumbers(l1,l2);
    }
}


