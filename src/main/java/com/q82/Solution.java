package com.q82;

import com.q86_partition_list.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 82. 删除排序链表中的重复元素 II
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode cur = pre.next;
		//pre   c
		//     p               p
		// 0-->1-->1-->1-->1-->2
		//pre c   p
		//0-->1-->4-->2
		while (cur != null) {

			int num = 0;
			ListNode p = cur;
			while (p != null && p.val == cur.val) {
				num++;
				p = p.next;
			}
			if (num > 1) {
				pre.next = p;
			}else {
				pre = cur;
			}
			cur = p;
		}
		return dummyHead.next;
	}
}
