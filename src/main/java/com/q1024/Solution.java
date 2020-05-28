package com.q1024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xjn
 * @since 2020-05-28
 * https://leetcode-cn.com/problems/video-stitching/
 * 1024:视频拼接
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        Comparator<int[]> comparator = (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        };
        Arrays.sort(clips, comparator);
        int cur = 0, res = 0;
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] > cur) {
                return -1;
            }
            int tmp = clips[i][1];
            while (i + 1 < clips.length && clips[i + 1][0] <= cur) {
                i++;
                tmp = Math.max(tmp, clips[i][1]);
            }
            res++;
            cur = tmp;
            if (cur >= T) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        System.out.println(solution.videoStitching(array, 10));
    }

}
