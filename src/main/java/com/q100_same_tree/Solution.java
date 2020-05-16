package com.q100_same_tree;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/same-tree/
 * 100. 相同的树
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
