package com.q0513_find_bottom_left_tree_value;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-29
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

    public int findBottomLeftValue(TreeNode root) {
        Pair<TreeNode, Integer> pair = new Pair<>(root, 1);
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(pair);
        Integer res = null;
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> remove = queue.remove();
            TreeNode key = remove.getKey();
            if (key != null) {
                Integer d = remove.getValue();
                if (d > depth) {
                    res = key.val;
                    depth = d;
                }
                if (key.left != null) {
                    queue.add(new Pair<TreeNode, Integer>(key.left, d + 1));
                }

                if (key.right != null) {
                    queue.add(new Pair<TreeNode, Integer>(key.right, d + 1));
                }
            }
        }
        return res;
    }
}
