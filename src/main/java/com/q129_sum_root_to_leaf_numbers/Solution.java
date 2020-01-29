package com.q129_sum_root_to_leaf_numbers;


import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-28
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 129. 求根到叶子节点数字之和
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

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> list = sumNumbersString(root);
        int sum = 0;
        for (String s : list) {
            int i = Integer.parseInt(s);
            sum += i;
        }
        return sum;
    }

    private List<String> sumNumbersString(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
        }
        List<String> leftList = sumNumbersString(root.left);
        for (String s : leftList) {
            list.add(root.val + s);
        }
        List<String> rightList = sumNumbersString(root.right);
        for (String s : rightList) {
            list.add(root.val + s);
        }
        return list;
    }


}
