package com.q199_binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-24
 */
public class Solution2 {
    private int max = Integer.MIN_VALUE;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        helper(root, 0, resList);
        return resList;
    }

    private void helper(TreeNode treeNode, int deep, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        if (deep > max) {
            max = deep;
            list.add(treeNode.val);
        }
        helper(treeNode.right, deep + 1, list);
        helper(treeNode.left, deep + 1, list);
    }

}