package com.q94_binary_tree_norder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 * 前序遍历  根左右
 * 中序遍历  左根右
 * 后序遍历: 左右根
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                resList.add(cur.val);
                stack.push(cur.left);
            }
        }
        return resList;
    }

    public static void main(String[] args) {

    }
}
