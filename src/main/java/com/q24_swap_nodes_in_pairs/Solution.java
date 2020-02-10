package com.q24_swap_nodes_in_pairs;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 24. 两两交换链表中的节点
 */
public class Solution {
    //返回交换链表之后的头结点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //1->2->3->4->null
        ListNode temp = head.next;
        //1->2<-4<-3
        head.next = swapPairs(temp.next);
        temp.next = head;
        head = null;
        return temp;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(test.swapPairs(head));
    }
}
