package com.q435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * 435. 无重叠区间
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        solution.eraseOverlapIntervals(nums);
    }
}
