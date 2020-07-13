package com.q0102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 时间复杂度 O(n)
 * 空间负载度 O(n)
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

    public List<List<Integer>> levelOrder(TreeNode root) {
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
                resList.get(level).add(treeNode.val);
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

    }
}
