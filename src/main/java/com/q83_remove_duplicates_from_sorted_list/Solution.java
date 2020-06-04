package com.q83_remove_duplicates_from_sorted_list;

/**
 * @author xjn
 * @since 2020-01-22
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            head = head.next;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 1, 1, 2, 3, 3};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode listNode = test.deleteDuplicates(head);
        System.out.println(listNode);
    }
}
