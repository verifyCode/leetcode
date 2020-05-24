package com.q96;

/**
 * @author xjn
 * @since 2020-05-24
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 */
public class Solution {
    /*
        假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
        1. G(n) = f(1) + f(2) + ... + f(n)
        当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
        2. f(i) = g(i-1) * g(n-i)

        1 && 2 ===> G(n) = G(0) * G(n - 1) + G(1) * G(n-2) + ... + G(n-1)*G(0)
     */

    public int numTrees(int n) {
        //dp[i] :  1 ... n 为节点组成的二叉搜索树有多少种
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
