package com.q993_cousins_in_binary_tree;

/**
 * @author xjn
 * @since 2020-01-30
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * 993. 二叉树的堂兄弟节点
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

    private TreeNode xNode, yNode;
    private int xLevel, yLevel;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        isCousins(root, x, y, 0);
        if (xNode == null || yNode == null) {
            return false;
        }
        return xNode.val != yNode.val && xLevel == yLevel;
    }

    public void isCousins(TreeNode root, int x, int y, int level) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val == x) {
                xNode = root;
                xLevel = level + 1;
            }
            if (root.left.val == y) {
                yNode = root;
                yLevel = level + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val == x) {
                xNode = root;
                xLevel = level + 1;
            }

            if (root.right.val == y) {
                yNode = root;
                yLevel = level + 1;
            }
        }
        isCousins(root.left, x, y, level + 1);
        isCousins(root.right, x, y, level + 1);
    }


}
