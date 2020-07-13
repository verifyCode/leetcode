package com.q0098_validate_binary_search_tree;

/**
 * @author xjn
 * @since 2020-01-29
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
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
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= last) {
            return false;
        }
        last = root.val;

        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    private boolean dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        if (root.val > max || root.val < min) {
            return false;
        }
        boolean a = dfs(root.left, root.val, min);
        boolean b = dfs(root.right, max, root.val);
        return a && b;
    }


}