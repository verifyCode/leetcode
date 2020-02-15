package com.q02_add_two_numbers;

import com.q203_remove_linked_list_elements.ListNode;

/**
 * @author xjn
 * @since 2020-02-15
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 2. 两数相加
 * 时间复杂度O(max(m,n))
 * 空间复杂度O(m+n)
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        int flag = 0;
        ListNode cur = dummyHead;
        while (l1 != null || l2 != null) {
            int vl1 = l1 == null ? 0 : l1.val;
            int vl2 = l2 == null ? 0 : l2.val;
            int sum = vl1 + vl2 + flag;
            flag = sum / 10;
            int val = sum % 10;
            cur.next = new ListNode(val);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (flag > 0) {
            cur.next = new ListNode(flag);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
