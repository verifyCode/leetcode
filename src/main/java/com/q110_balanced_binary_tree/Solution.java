package com.q110_balanced_binary_tree;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 110. 平衡二叉树
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);

        if (Math.abs(rightLevel - leftLevel) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int countLevel(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = countLevel(treeNode.left) + 1;
        int right = countLevel(treeNode.right) + 1;
        return Math.max(left, right);
    }
}
