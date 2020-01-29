package com.q101_symmetric_tree;

/**
 * @author xjn
 * @since 2020-01-28
 */
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

}