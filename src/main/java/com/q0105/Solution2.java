package com.q0105;

import com.q0104_maximum_depth_of_binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	//key:inorder[index],Value:index
	private Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		map.clear();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
		if (pStart > pEnd || iStart > iEnd){
			return null;
		}
		TreeNode node = new TreeNode(preorder[pStart]);
		int rootPos = map.get(preorder[pStart]);
		int leftNum = rootPos - iStart;
		//前序:根左右
		//中序:左根右
		node.left = helper(preorder,pStart + 1,pStart + leftNum,inorder,iStart,iStart +  leftNum);
		node.right = helper(preorder,pStart + leftNum + 1,pEnd,inorder,rootPos + 1,iEnd);
		return node;

	}
}
