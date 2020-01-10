package com.recursive.q02_swapPairs;


/**
 * @author xjn
 * @since 2019-12-18
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head.next;
        head.next = swapPairs(head.next);
        prev.next = head;
        return prev;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        test.swapPairs(head);
        System.out.println(head);

    }

}
