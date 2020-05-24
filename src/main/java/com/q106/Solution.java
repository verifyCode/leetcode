package com.q106;

import com.q101_symmetric_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xjn
 * @since 2020-05-24
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    //中序遍历:左根右
    //后续遍历:左右根
    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        //
        TreeNode root = new TreeNode(postorder[pEnd]);
        int rootPos = map.get(postorder[pEnd]);
        int rightNum = iEnd - rootPos;
        root.left = helper(inorder, iStart, rootPos - 1, postorder, pStart, pEnd - rightNum - 1);
        root.right = helper(inorder, rootPos + 1, iEnd, postorder, pEnd - rightNum, pEnd - 1);
        return root;
    }
}
