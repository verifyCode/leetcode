package com.q0097_interleaving_string;

/**
 * @author xjn
 * @since 2020-01-08
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //TODO
    public boolean isInterleave(String s1, String s2, String s3) {
        // dp[i][j] s1[0~i] s2[0~j] --> s3[i~j]
        // dp[i][j] = dp
        return false;
    }
    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
