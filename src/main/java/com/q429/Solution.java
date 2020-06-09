package com.q429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-06-07
 * 429. N叉树的层序遍历
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            Queue<Node> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> nodeList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node nodeFromQueue = queue.remove();
                    if (nodeFromQueue != null) {
                        nodeList.add(nodeFromQueue.val);
                        if (nodeFromQueue.children != null) {
                            for (Node node : nodeFromQueue.children) {
                                queue.add(node);
                            }
                        }
                    }
                }
                lists.add(nodeList);
            }
            return lists;
        }
    }
}
