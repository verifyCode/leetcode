package com.q105;

import com.q104_maximum_depth_of_binary_tree.TreeNode;

import java.lang.reflect.WildcardType;

/***
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
		//pStart可以等于pEnd
		if (pStart > pEnd || iStart > iEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pStart]);
		int step = 0;
		while (preorder[pStart] != inorder[iStart + step]) {
			step++;
		}
		//前序:根左右
		//中序:左根右
		root.left = dfs(preorder, pStart + 1, pEnd, inorder, iStart, iStart + step - 1);
		root.right = dfs(preorder, pStart + step + 1, pEnd, inorder, iStart + step + 1, pEnd);
		return root;
	}

}
