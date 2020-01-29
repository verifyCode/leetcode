package com.q257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 257. 二叉树的所有路径
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
        }

        List<String> leftList = binaryTreePaths(root.left);
        for (int i = 0; i < leftList.size(); i++) {
            list.add(root.val + "->" + leftList.get(i));
        }
        List<String> rightLeft = binaryTreePaths(root.right);
        for (int i = 0; i < rightLeft.size(); i++) {
            list.add(root.val + "->" + rightLeft.get(i));
        }
        return list;
    }
}
