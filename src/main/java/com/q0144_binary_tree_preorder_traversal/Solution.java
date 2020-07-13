package com.q0144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {

    //前序遍历(dfs)---> 根左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                resList.add(pop.val);
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {

    }

}
