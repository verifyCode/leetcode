package com.q11_container_with_most_water;

/**
 * @author xjn
 * @since 2020-02-15
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11. 盛最多水的容器
 * 时间复杂度:O(n/2)
 * 空间复杂度:O(1)
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int a = Math.min(height[left], height[right]);
            int b = Math.abs(right - left);
            max = Math.max(a * b, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
