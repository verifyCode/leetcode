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
        ListNode rHead = reverseList(head.next);
        //head.next此刻指向head后面的链表的尾节点
        //head->next->next = head把head节点放在了尾部
        head.next.next = head;
        head.next = null;
        return rHead;
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
