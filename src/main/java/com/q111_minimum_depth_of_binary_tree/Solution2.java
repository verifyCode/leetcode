package com.q111_minimum_depth_of_binary_tree;

/**
 * @author xjn
 * @since 2020-01-28
 */
public class Solution2 {
    private class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftMinLevel = Integer.MAX_VALUE;
        if (root.left != null) {
            leftMinLevel = minDepth(root.left);
        }
        int rightMinLevel = Integer.MAX_VALUE;
        if (root.right != null) {
            rightMinLevel = minDepth(root.right);
        }
        return Math.min(rightMinLevel, leftMinLevel) + 1;
    }
}
