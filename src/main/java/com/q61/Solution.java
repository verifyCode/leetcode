package com.q61;

import com.q86_partition_list.ListNode;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 61. 旋转链表
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLength(head);
        k = k % len;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        ListNode start = head;
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;
        return head;
    }
    //s-->n
    //h = s.next ==> h --> n

    //        s      end
    //1-->2-->3-->4-->5-->null
    //4-->5-->1-->2-->3-->null
    private int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
