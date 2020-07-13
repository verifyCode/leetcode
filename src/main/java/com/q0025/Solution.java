package com.q0025;

import com.q0203_remove_linked_list_elements.ListNode;


/**
 * @author xjn
 * @since 2020-06-03
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 25. K 个一组翻转链表
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                //如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
                return head;
            }
            tail = tail.next;
        }
        //h
        //1-->2-->3-->4-->5-->6-->7-->null
        //n   h
        //2-->1-->3-->4-->5-->6-->7-->null
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    //左闭右开区间
    //p   c   n
    //1-->2--3-->4
    //
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
