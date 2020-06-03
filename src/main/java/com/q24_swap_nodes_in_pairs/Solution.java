package com.q24_swap_nodes_in_pairs;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/proble`	ms/swap-nodes-in-pairs/
 * 24. 两两交换链表中的节点
 * 时间复杂度 O()
 */
public class Solution {
    //返回交换链表之后的头结点
    public ListNode swapPairs(ListNode head, int level) {
        if (head == null || head.next == null) {
            return head;
        }
        //1->2->3->4->null
        ListNode temp = head.next;
        //1->2<-4<-3
        System.out.println(generateString(level));
        head.next = swapPairs(temp.next, level + 1);
        System.out.println(generateString(level));
        temp.next = head;
        head = null;
        return temp;
    }

    private String generateString(int level) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
//        System.out.println(head);
        System.out.println(test.swapPairs(head, 0));
    }
}
