package com.q206_reverse_linked_list;

/**
 * @author xjn
 * @since 2020-01-22
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //这里入参的head.next的head和递归完成之后的head有什么不同?
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println("init-head:" + head);
        ListNode reverseList = test.reverseList(head);
        System.out.println("res-head:" + reverseList);
    }

}
