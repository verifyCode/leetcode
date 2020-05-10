package com.q104_maximum_depth_of_binary_tree;


/**
 * @author xjn
 * @since 2019-12-25
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
