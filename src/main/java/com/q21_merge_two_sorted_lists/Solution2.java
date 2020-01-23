package com.q21_merge_two_sorted_lists;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode listNode1 = new ListNode(nums1);
        ListNode listNode2 = new ListNode(nums2);
        ListNode listNode = test.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }
}
