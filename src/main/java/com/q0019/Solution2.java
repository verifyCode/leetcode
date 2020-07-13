package com.q0019;

import com.q0086_partition_list.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第N个节点
 * 
 */
public class Solution2 {
	int i;
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			i = 0;
			return null;
		}
		head.next = removeNthFromEnd(head.next, n);
		i++;
		//倒数第n+1个节点
		if (n == i) {
			return head.next;
		}
		return head;
	}

}
