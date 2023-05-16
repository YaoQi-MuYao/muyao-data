package com.data.leetcode.question;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XiaoXiao
 * @Date 2023/5/16 16:55
 **/
public class Q11 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9, new ListNode(8,new ListNode(7)));
        ListNode listNode2 = new ListNode(5, new ListNode(1,new ListNode(2)));
        ListNode node = addTwoNumbers(listNode1, listNode2);
        System.out.println(node.toString());
    }

    public static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        while (listNode1 != null) {
            queue1.push(listNode1.val);
            listNode1 = listNode1.next;
        }
        while (listNode2 != null) {
            queue2.push(listNode2.val);
            listNode2 = listNode2.next;
        }
        ListNode result = null;
        boolean c = false;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            int a = queue1.isEmpty() ? 0 : queue1.pop();
            int b = queue2.isEmpty() ? 0 : queue2.pop();
            int res = a - b;
            ListNode listNode = new ListNode(res);
            listNode.next = result;
            result = listNode;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.val + "" + (this.next == null ? "" : this.next);
    }
}
