package com.q206_reverse_linked_list;
/**
 * @author xjn
 * @since 2020-01-22
 * {@Link com.recursive.q05_reverseList.Solution }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = head.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println("init-head:" + head);
        ListNode reverseList = test.reverseList(head);
        System.out.println("res-head:" + reverseList);
    }
}
