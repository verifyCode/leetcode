package com.q993_cousins_in_binary_tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-30
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

    private TreeNode xNode, yNode;
    private int xLevel, yLevel;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0);
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(pair);
        int level = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> remove = queue.remove();
            TreeNode node = remove.getKey();
            if (node != null) {
                Integer d = remove.getValue();
                level = Math.max(d, level);
                if (node.left != null) {
                    if (node.left.val == x) {
                        xNode = node;
                        xLevel = level + 1;
                    }
                    if (node.left.val == y) {
                        yNode = node;
                        yLevel = level + 1;
                    }
                    queue.add(new Pair<>(node.left, d + 1));
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        xNode = node;
                        xLevel = level + 1;
                    }

                    if (node.right.val == y) {
                        yNode = node;
                        yLevel = level + 1;
                    }
                    queue.add(new Pair<>(node.right, d + 1));

                }
            }
        }

        if (xNode == null || yNode == null) {
            return false;
        }
        return xNode.val != yNode.val && xLevel == yLevel;
    }
}
