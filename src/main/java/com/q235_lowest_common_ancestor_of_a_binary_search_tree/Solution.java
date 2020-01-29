package com.q235_lowest_common_ancestor_of_a_binary_search_tree;

/**
 * @author xjn
 * @since 2020-01-29
 * <p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 235. 二叉搜索树的最近公共祖先
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
