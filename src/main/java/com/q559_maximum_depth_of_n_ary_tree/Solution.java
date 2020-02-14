package com.q559_maximum_depth_of_n_ary_tree;


import java.util.List;

/**
 * @author xjn
 * @since 2019-12-27
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 559. N叉树的最大深度
 */
public class Solution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> children = root.children;
        if (children == null || children.size() == 0) {
            return 1;
        }
        int res = Integer.MIN_VALUE;
        for (Node node : children) {
            res = Math.max(maxDepth(node) + 1, res);
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
