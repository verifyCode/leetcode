package com.q513_find_bottom_left_tree_value;

import com.q101_symmetric_tree.TreeNode;

/**
 * @author xjn
 * @since 2020-02-11
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * 513. 找树左下角的值
 */
public class Solution2 {
	private int level = -1;
	private int res   = -1;

	public int findBottomLeftValue(TreeNode root) {
		dfs(root, 0);
		return res;
	}

	private void dfs(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (this.level < level) {
				this.level = level;
				this.res = root.val;
			}
		}
		dfs(root.left, level + 1);
		dfs(root.right, level + 1);
	}

	public static void main(String[] args) {

	}
}
