package com.q75sort_colors;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-01-09
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }

        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }

        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
