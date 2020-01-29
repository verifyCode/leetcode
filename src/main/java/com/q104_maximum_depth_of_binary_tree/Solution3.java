package com.q104_maximum_depth_of_binary_tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-28
 */
public class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Pair<TreeNode, Integer> pair = new Pair<>(root, 1);
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(pair);
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> remove = queue.remove();
            TreeNode treeNode = remove.getKey();
            int d = remove.getValue();
            depth = Math.max(depth, d);
            if (treeNode != null) {
                if (treeNode.left != null) {
                    Pair<TreeNode, Integer> p = new Pair<>(treeNode.left, d + 1);
                    queue.add(p);
                }

                if (treeNode.right != null) {
                    Pair<TreeNode, Integer> p = new Pair<>(treeNode.right, d + 1);
                    queue.add(p);
                }
            }
        }
        return depth;
    }

}
