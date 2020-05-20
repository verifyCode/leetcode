package com.q86_partition_list;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author xjn
 * @since 2020-01-23
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//TODO
public class Solution {
    public ListNode partition(ListNode head, int x) {
//        ListNode leftHead = new ListNode(0);
//        ListNode left = leftHead;
//        ListNode midHead = new ListNode(0);
//        ListNode mid = midHead;
//        ListNode rightHead = new ListNode(0);
//        ListNode right = rightHead;
//        while (head != null) {
//            if (head.val < x) {
//                left.next = head;
//                left = left.next;
//            } else if (head.val == x) {
//                mid.next = head;
//                mid = mid.next;
//            } else {
//                right.next = head;
//                right = right.next;
//            }
//            head = head.next;
//        }
//        System.out.println("leftHead:" + leftHead);
//        System.out.println("left:" + left);
//        System.out.println("midHead:" + midHead);
//        System.out.println("mid:" + mid);
//        System.out.println("rightHead:" + rightHead);
//        System.out.println("right:" + right);
//        left.next = midHead.next;
//        mid.next = rightHead.next;
//        return leftHead.next;
        return null;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 4, 2, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(test.partition(head, 2));
    }


}
