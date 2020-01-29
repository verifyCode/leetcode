package com.q98_validate_binary_search_tree;

/**
 * @author xjn
 * @since 2020-01-29
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 */
public class Solution2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int last = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return false;
    }
}