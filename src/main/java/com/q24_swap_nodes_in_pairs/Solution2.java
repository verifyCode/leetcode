package com.q24_swap_nodes_in_pairs;

public class Solution2 {

	//1->2->3->4
	//TODO
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode a = dummyHead;
		ListNode b = dummyHead;
		ListNode temp = dummyHead;
		//   a  b
		//1->2->3->4
		while (a != null && b != null && b.next.next != null){
			a = a.next;
			b = b.next.next;
			temp.next = b;
			a.next = b.next;
			b.next = a;
			temp = a;
			b = a;
		}
		return dummyHead.next;

	}

}
