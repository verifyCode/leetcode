package com.q141_linked_list_cycle;

import com.q203_remove_linked_list_elements.ListNode;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 141. 环形链表
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
