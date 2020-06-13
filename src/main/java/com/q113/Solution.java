package com.q113;

import com.q104_maximum_depth_of_binary_tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 113. 路径总和 II
 */
public class Solution {
	List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return lists;
		}
		helper(root, sum, new ArrayDeque<>());
		return lists;
	}

	private void helper(TreeNode root, int sum, Deque<Integer> path) {
		if (root == null) {
			return;
		}
		sum = sum - root.val;
		path.add(root.val);
		if (sum == 0 && root.left == null && root.right == null) {
			lists.add(new ArrayList<>(path));
			path.removeLast();
			return;
		}
		helper(root.left, sum, path);
		helper(root.right, sum, path);
		if(path.size()> 0)
		path.removeLast();
	}


}
