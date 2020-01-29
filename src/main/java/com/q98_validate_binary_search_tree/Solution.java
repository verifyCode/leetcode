package com.q98_validate_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-29
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        isValidBST(root, list);
        if (list.size() == 1) {
            return true;
        }
        return isSorted(list);
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1))
                return false;
        }
        return true;
    }

    private void isValidBST(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        isValidBST(root.left, list);
        list.add(root.val);
        isValidBST(root.right, list);
    }
}
