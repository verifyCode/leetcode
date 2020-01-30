package com.q107_binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-29
 */
public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> onLevelList = new ArrayList<>();
            int count = queue.size();
            //一次取出一层节点
            for (int i = 0; i < count; i++) {
                TreeNode remove = queue.remove();
                if (remove != null) {
                    onLevelList.add(remove.val);
                }
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            resList.add(0, onLevelList);
        }
        return resList;
    }
}