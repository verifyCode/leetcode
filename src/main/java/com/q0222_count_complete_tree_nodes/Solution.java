package com.q0222_count_complete_tree_nodes;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 222. 完全二叉树的节点个数
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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left) + 1;
        int right = countNodes(root.right) + 1;
        return left +right;
    }

}
