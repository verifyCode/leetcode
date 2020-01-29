package com.q226_invert_binary_tree;

/**
 * @author xjn
 * @since 2020-01-27
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 226. 翻转二叉树
 */
public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode rightNode = root.right;
//        root.right = invertTree(root.left);
//        root.left = invertTree(rightNode);
//        return root;
//    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }


}
