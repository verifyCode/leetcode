package com.q513_find_bottom_left_tree_value;

import com.q101_symmetric_tree.TreeNode;

/**
 * @author xjn
 * @since 2020-02-11
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * 513. 找树左下角的值
 */
public class Solution2 {
    private int level = -1;

    public int findBottomLeftValue(TreeNode root) {
        TreeNode dfs = dfs(root, 0);
        if(dfs == null){
            return 0;
        }
        return dfs.val;
    }

    private TreeNode dfs(TreeNode root, int level) {
        if (root == null) {
            return null;
        }
        if (this.level < level) {
            this.level = level;
        } else {
            return root;
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
        return null;
    }

    public static void main(String[] args) {

    }
}
