package com.q23;

import com.q203_remove_linked_list_elements.ListNode;

import java.util.PriorityQueue;

/**
 * @author xjn
 * @since 2020-06-03
 * 23. 合并K个排序链表
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b)-> a.val - b.val);
        for(ListNode listNode : lists){
            if(listNode != null) {
                priorityQueue.add(listNode);
            }
        }
        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            cur.next = poll;
            cur = poll;
            if(poll.next != null) {
                priorityQueue.add(poll.next);
            }
        }
        return dummyHead.next;
    }
}
