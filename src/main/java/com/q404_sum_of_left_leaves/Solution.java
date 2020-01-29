package com.q404_sum_of_left_leaves;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 404. 左叶子之和
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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sum + sumOfLeftLeaves(root.right);
    }
}
