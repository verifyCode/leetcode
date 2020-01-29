package com.q279_perfect_squares;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjn
 * @since 2020-01-26
 * https://leetcode-cn.com/problems/perfect-squares/
 * 279. 完全平方数
 */
public class Solution {
    private class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        queue.add(new Node(n, 0));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int step = node.step;
            int num = node.val;

            if (num == 0) {
                return step;
            }

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return step + 1;
                }
                if (!visited[a]) {
                    queue.add(new Node(a, step + 1));
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.numSquares(12));
        System.out.println(test.numSquares(7168));
    }
}
