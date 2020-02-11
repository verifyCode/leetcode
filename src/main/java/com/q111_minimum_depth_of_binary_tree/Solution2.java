package com.q111_minimum_depth_of_binary_tree;

/**
 * @author xjn
 * @since 2020-01-28
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 111. 二叉树的最小深度
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
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
}
