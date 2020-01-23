package com.q21_merge_two_sorted_lists;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        ListNode listNode1 = new ListNode(nums1);
        ListNode listNode2 = new ListNode(nums2);
        ListNode listNode = test.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }
}
