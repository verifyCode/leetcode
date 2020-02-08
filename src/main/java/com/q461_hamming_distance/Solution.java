package com.q461_hamming_distance;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/hamming-distance/
 * 461. 汉明距离
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1, 4));
    }
}
