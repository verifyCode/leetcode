package com.q0199_binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-24
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 199. 二叉树的右视图
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

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return null;
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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < resList.size(); i++) {
            List<Integer> tempList = resList.get(i);
            list.add(tempList.get(tempList.size() - 1));
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
