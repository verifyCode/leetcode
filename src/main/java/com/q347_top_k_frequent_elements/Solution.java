package com.q347_top_k_frequent_elements;

import java.util.*;

/**
 * @author xjn
 * @since 2020-01-27
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 347. 前 K 个高频元素
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> {
            return e2.getValue() - e1.getValue();
        });
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        map.entrySet().forEach(e -> {
            priorityQueue.add(e);
        });
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = priorityQueue.poll();
            list.add(poll.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.println(test.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
//        System.out.println(test.topKFrequent(new int[]{1}, 1));
        System.out.println(test.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }
}
