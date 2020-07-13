package com.q0019;

import com.q0086_partition_list.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 * 19. 删除链表的倒数第N个节点
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null){
			return head;
		}
		ListNode p = head;
		ListNode q = head;
		while (p != null){
			if(n < 0){
				q = q.next;
			}
			p = p.next;
			n --;
		}
		if(n == 0){
			return head.next;
		}
		q.next = q.next.next;
		return head;
	}
}
