package com.q0108;

import com.q0101_symmetric_tree.TreeNode;

/**
 * @author xjn
 * @since 2020-02-16
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 108. 将有序数组转换为二叉搜索树
 * 时间复杂度O(n)
 * 空间复杂度O(logN)
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }


    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (nums == null) {
            return null;
        }
        if (l > r) {
            return null;
        }

        int mid = l + (r - l + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = sortedArrayToBST(nums, l, mid - 1);
        TreeNode right = sortedArrayToBST(nums, mid + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

    }
}
