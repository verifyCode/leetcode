package com.q337_house_robber_iii;

import com.q101_symmetric_tree.TreeNode;

/**
 * @author xjn
 * @since 2020-02-09
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 337. 打家劫舍 III
 */
public class Solution {

    //1. 抢 然后去下下家
    //2. 不抢 去下一家
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = 0;
        //抢 然后去下下家
        if (root.left != null) {
            a = a + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            a = a + rob(root.right.right) + rob(root.right.left);
        }
        //不抢 然后去下一家
        int b = 0;
        if (root.left != null) {
            b = b + rob(root.left);
        }
        if (root.right != null) {
            b = b + rob(root.right);
        }
        return Math.max(a, b);
    }
}
