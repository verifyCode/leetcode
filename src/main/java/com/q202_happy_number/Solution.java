package com.q202_happy_number;


import java.util.Set;
import java.util.TreeSet;

/**
 * @author xjn
 * @since 2020-01-21
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isHappy(int n) {
        String s = n + "";
        Set<Integer> set = new TreeSet<>();
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int temp = Integer.parseInt(s.charAt(i) + "");
                sum = sum + temp * temp;
            }
            s = sum + "";
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.isHappy(19));
    }
}
