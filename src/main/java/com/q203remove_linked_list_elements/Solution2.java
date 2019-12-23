package com.q203remove_linked_list_elements;


/**
 * @author xjn
 * @since 2019-12-17
 */
public class Solution2 {
    //递归
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode listNode = removeElements(head.next, val);
        if (head.val == val) {
            return listNode;
        } else {
            head.next = listNode;
        }
        return head;

    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode listNode = test.removeElements(head, 6);
        System.out.println(listNode);
    }

}
