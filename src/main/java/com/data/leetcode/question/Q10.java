package com.data.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoXiao
 * @Date 2022/11/14 19:50
 **/
public class Q10 {


    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //
    //
    //
    // 示例 1：
    //
    //
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //
    //
    // 示例 2：
    //
    //
    //输入：l1 = [], l2 = []
    //输出：[]
    //
    //
    // 示例 3：
    //
    //
    //输入：l1 = [], l2 = [0]
    //输出：[0]
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(4, new ListNode(5, new ListNode(6)));
        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }


    /**
     * 递归 沙雕版
     *
     * @param list1
     * @param list2
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        } else if (null == list2) {
            return list1;
        } else {
            ListNode list3 = new ListNode();
            add(list1, list2, list3);
            return list3;
        }
    }

    public static void add(ListNode list1, ListNode list2, ListNode list3) {
        if (list1.val > list2.val) {
            list3.val = list2.val;
            ListNode list4 = new ListNode();
            if (list2.next != null) {
                add(list1, list2.next, list4);
            } else {
                list4 = list1;
            }
            list3.next = list4;
        } else {
            list3.val = list1.val;
            ListNode list4 = new ListNode();
            if (list1.next != null) {
                add(list1.next, list2, list4);
            } else {
                list4 = list2;
            }
            list3.next = list4;
        }
    }


    /**
      * 递归牛逼版
      * @author muyao
      * @date 2022/11/14 21:46
      **/
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            else if (l2 == null) {
                return l1;
            }
            else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }

        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
