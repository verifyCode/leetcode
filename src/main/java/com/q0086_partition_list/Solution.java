package com.q0086_partition_list;

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
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);

        ListNode p1 = dummyHead1;
        ListNode p2 = dummyHead2;

        ListNode cur = head;
        //1-->2-->3-->4
        //
        while (cur != null){
            if(cur.val < x){
                p1.next = cur;
                p1 = p1.next;
                p1.next = null;
            }else {
                p2.next = cur;
                p2 = p2.next;
                p2.next = null;
            }
            cur = cur.next;
        }
        p1.next = dummyHead2.next;
        return dummyHead1.next;

    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {1, 4, 2, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(test.partition(head, 2));
    }


}
