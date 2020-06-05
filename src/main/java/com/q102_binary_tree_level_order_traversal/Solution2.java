package com.q102_binary_tree_level_order_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-06-05
 */
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                list.add(remove.val);
                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
