package com.q24_swap_nodes_in_pairs;

/**
 * @author xjn
 * @since 2020-06-03
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution2 {
    //p  n1  n2
    //0-->1-->2-->3->4->5
    //0-->2-->1-->3
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return dummyHead.next;
    }
}
