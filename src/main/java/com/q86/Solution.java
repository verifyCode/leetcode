package com.q86;

import com.q86_partition_list.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 86. 分隔链表
 */
public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode dummyHead1 = new ListNode(0);
		ListNode dummyHead2 = new ListNode(0);
		ListNode prev1 = dummyHead1;
		ListNode prev2 = dummyHead2;
		//x 3
		//p1  c
		//0-->1-->4-->3-->2-->5-->2
		//0-->1-->2-->2-->4-->3-->5
		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				prev1.next = cur;
				cur = cur.next;
				prev1 = prev1.next;
				prev1.next = null;
			} else {
				prev2.next = cur;
				cur = cur.next;
				prev2 = prev2.next;
				prev2.next = null;
			}
		}
		prev1.next = dummyHead2.next;
		return dummyHead1.next;
	}
}
