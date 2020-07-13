package com.q0113;

import com.q0101_symmetric_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 113. 路径总和 II
 */
public class Solution2 {

	private List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			lists.clear();
			return lists;
		}
		Deque<Integer> deque = new ArrayDeque<>();
		helper(root, sum, deque);
		return lists;
	}

	private void helper(TreeNode root, int sum, Deque<Integer> deque) {
		if (root == null) {
			return;
		}
		if (sum == root.val && root.right == null && root.left == null) {
			deque.add(root.val);
			lists.add(new ArrayList<>(deque));
			deque.removeLast();
			return;
		}
		helper(root.left, sum - root.val, deque);
		helper(root.right, sum - root.val, deque);
	}
}
