package com.q129_sum_root_to_leaf_numbers;

import com.q101_symmetric_tree.TreeNode;

public class Solution2 {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return helper(root, 0);
	}

	private int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}
		return helper(root.left, sum) + helper(root.right, sum);
	}
}
