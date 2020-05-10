package com.q103_binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-24
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. 二叉树的锯齿形层次遍历
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
public class Solution {
    private class Tree {
        TreeNode treeNode;
        int level;

        public Tree(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<Tree> queue = new LinkedList<>();
        Tree tree = new Tree(root, 0);
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree remove = queue.remove();
            TreeNode treeNode = remove.treeNode;
            int level = remove.level;
            if (level == resList.size()) {
                List<Integer> list = new ArrayList<>();
                resList.add(list);
            }
            if (treeNode != null) {
                if ((level + 1) % 2 == 0) {
                    resList.get(level).add(0, treeNode.val);
                } else {
                    resList.get(level).add(treeNode.val);
                }
            }
            if (treeNode.left != null) {
                Tree temp = new Tree(treeNode.left, level + 1);
                queue.add(temp);
            }
            if (treeNode.right != null) {
                Tree temp = new Tree(treeNode.right, level + 1);
                queue.add(temp);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(0 % 2);
        System.out.println(1 % 2);
        System.out.println(2 % 2);

        List<Integer> list = new ArrayList<>();
        list.add(0, 9);
        list.add(0, 20);
        System.out.println(list);
    }
}
