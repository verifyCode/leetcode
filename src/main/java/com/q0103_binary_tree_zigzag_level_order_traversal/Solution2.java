package com.q0103_binary_tree_zigzag_level_order_traversal;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. 二叉树的锯齿形层次遍历
 */
public class Solution2 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists = new LinkedList<>();
		if (root == null) {
			return lists;
		}

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			LinkedList<Integer> linkedList = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if (poll != null) {
					if (level % 2 == 0) {
						linkedList.addFirst(poll.val);
					} else {
						linkedList.addLast(poll.val);
					}
					if (poll.left != null) {
						queue.add(poll.left);
					}
					if (poll.right != null) {
						queue.add(poll.right);
					}

				}
			}
			lists.add(linkedList);
		}
		return lists;
	}
}
