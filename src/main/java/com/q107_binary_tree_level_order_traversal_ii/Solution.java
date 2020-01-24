package com.q107_binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-24
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 107. 二叉树的层次遍历 II
 */
public class Solution {
    private class Tree {
        public TreeNode treeNode;
        public int level;

        public Tree(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        Tree tree = new Tree(root, 0);
        queue.add(tree);
        int temp = 0;
        while (!queue.isEmpty()) {
            Tree remove = queue.remove();
            int level = remove.level;
            TreeNode treeNode = remove.treeNode;
            if (treeNode != null) {
                if (level == queue.size()) {
                    List<Integer> list = new ArrayList<>();
                    resList.add(list);
                }
                if (temp == level) {
                }
                if (treeNode.left != null) {
                    queue.add(new Tree(treeNode.left, level + 1));
                }
                if (treeNode.right != null) {
                    queue.add(new Tree(treeNode.right, level + 1));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(resList.size());
        for(int i = resList.size() - 1; i >= 0; i --){
            res.add(resList.get(i));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
