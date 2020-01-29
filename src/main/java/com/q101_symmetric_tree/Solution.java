package com.q101_symmetric_tree;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 101. 对称二叉树
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
