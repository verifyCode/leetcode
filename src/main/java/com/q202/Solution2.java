package com.q202;

/**
 * @author xjn
 * @since 2019-12-17
 */
public class Solution2 {
    //递归
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {

    }

}
