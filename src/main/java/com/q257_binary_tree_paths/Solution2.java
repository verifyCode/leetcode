package com.q257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-28
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 257. 二叉树的所有路径
 */
public class Solution2 {
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
        //["1","1->2","1->2->5","1->3"]
        //["1->2->5","1->3"]
        if(root.left == null && root.right == null) {
            list.add(root.val + "");
        }
        List<String> leftList = binaryTreePaths(root.left);
        for (String s : leftList) {
            list.add(root.val + "->" + s);
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (String s : rightList) {
            list.add(root.val + "->" + s);
        }
        return list;
    }
}
