package com.recursive.q05reverseList;

import com.recursive.q02swapPairs.ListNode;

/**
 * https://leetcode-cn.com/explore/orignial/card/recursion-i/257/recurrence-relation/1210/
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author xjn
 * @since 2019-12-18
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode reverseList = test.reverseList(head);
        System.out.println(reverseList);
    }
}
