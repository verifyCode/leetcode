package com.q559_maximum_depth_of_n_ary_tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-29
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * 559. N叉树的最大深度
 */
public class Solution2 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Pair<Node, Integer> pair = new Pair<>(root, 1);
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(pair);
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<Node, Integer> remove = queue.remove();
            Node node = remove.getKey();
            int d = remove.getValue();
            depth = Math.max(d, depth);
            if (node.children != null) {
                for (Node n : node.children) {
                    queue.add(new Pair<>(n, d + 1));
                }
            }
        }
        return depth;
    }

}
