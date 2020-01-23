package com.q92_reverse_linked_list_ii;

/**
 * @author xjn
 * @since 2020-01-22
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>      left
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载 请注明出处。
 */
public class Solution {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null;
    private ListNode reverseN(ListNode head, int count) {
        if (count == 1) {
            successor = head.next;
            return head;
        }
        ListNode ret = reverseN(head.next, count - 1);
        head.next.next = head;
        head.next = successor;
        return ret;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(test.reverseBetween(head, 2, 4));
    }

}
