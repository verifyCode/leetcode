package com.q111_minimum_depth_of_binary_tree;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 111. 二叉树的最小深度
 */
public class Solution {
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
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

}
