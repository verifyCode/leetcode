package com.q109;

import com.q104_maximum_depth_of_binary_tree.TreeNode;
import com.q86_partition_list.ListNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 109. 有序链表转换二叉搜索树
 */
public class Solution {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		return buildTree(head, null);
	}

	private TreeNode buildTree(ListNode head, ListNode tail) {
		if (head == tail) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode root = new TreeNode(slow.val);
		root.left = buildTree(head, slow);
		root.right = buildTree(slow.next, tail);
		return root;
	}


}
