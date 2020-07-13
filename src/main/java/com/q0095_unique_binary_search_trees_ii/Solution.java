package com.q0095_unique_binary_search_trees_ii;

import com.q0101_symmetric_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-02-10
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 95. 不同的二叉搜索树 II
 * 时间复杂度O(n^n)
 * 空间复杂度O(n^n)
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = dfs(start, i - 1);
            List<TreeNode> rightList = dfs(i + 1, end);
            for (TreeNode l : leftList) {
                for (TreeNode r : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
