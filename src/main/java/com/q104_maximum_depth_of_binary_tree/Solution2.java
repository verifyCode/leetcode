package com.q104_maximum_depth_of_binary_tree;


import javafx.util.Pair;

import java.util.Stack;

/**
 * @author xjn
 * @since 2020-01-28
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 104. 二叉树的最大深度
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //k:node v:depth
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0);
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(pair);
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pop = stack.pop();
            TreeNode treeNode = pop.getKey();
            if (treeNode != null) {
                int d = pop.getValue();
                depth = Math.max(d, depth);
                System.out.println(d);
                if (treeNode.right != null) {
                    Pair<TreeNode, Integer> p = new Pair<>(treeNode.right, d + 1);
                    stack.push(p);
                }

                if (treeNode.left != null) {
                    Pair<TreeNode, Integer> p = new Pair<>(treeNode.left, d + 1);
                    stack.push(p);
                }
            }
        }
        return depth + 1;
    }

}
