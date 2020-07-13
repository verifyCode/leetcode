package com.q0215_kth_largest_element_in_an_array;

/**
 * @author xjn
 * @since 2020-01-09
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    //求出nums[l...r]范围里第k小的数
    private int findKthLargest(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int p = partition(nums, l, r);
        if (k == p) {
            return nums[p];
        } else if (k < p) {
            return findKthLargest(nums, l, p - 1, k);
        } else {
            return findKthLargest(nums, p + 1, r, k);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int leftRange = l; //[l + 1...leftRange] < v
        int rightRange = r + 1;//[rightRange ... r] > v
        int i = l;//[leftRange+1...i] =v
        while (i < rightRange) {
            if (nums[i] < v) {
                swap(nums, i, leftRange + 1);
                leftRange++;
                i++;
            } else if (nums[i] == v) {
                i++;
            } else if (nums[i] > v) {
                swap(nums, i, rightRange - 1);
                rightRange--;
            }
        }
        swap(nums, l, leftRange);
        return leftRange;
    }

    private void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(test.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
    }
}
