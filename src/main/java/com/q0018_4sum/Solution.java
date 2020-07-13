package com.q0018_4sum;

import java.util.List;

/**
 * @author xjn
 * @since 2020-01-21
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//TODO
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            int l = i + 2;
//            int r = nums.length - 1;
//            int sum = nums[i] + nums[i + 1];
//            while (l < r) {
//                List<Integer> list = new ArrayList<>();
//                if (nums[l] + nums[r] + sum == target) {
//                    list.add(nums[l]);
//                    list.add(nums[r]);
//                    list.add(nums[i]);
//                    list.add(nums[i + 1]);
//                    while (l < r && nums[l] == nums[l + 1]) {
//                        l++;
//                    }
//                    while (l < r && nums[r] == nums[r - 1]) {
//                        r--;
//                    }
//                    l++;
//                    r--;
//                    res.add(list);
//                } else if (nums[l] + nums[r] + sum > target) {
//                    r--;
//                } else {
//                    l++;
//                }
//            }
//        }
//        return res;
        return null;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = test.fourSum(nums, target);
        System.out.println(lists);
    }

}
