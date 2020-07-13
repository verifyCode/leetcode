package com.q0094_binary_tree_norder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-23
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 * 二叉树中序遍历
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
