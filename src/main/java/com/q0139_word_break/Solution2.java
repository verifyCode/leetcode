package com.q0139_word_break;


import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author xjn
 * @since 2020-02-11
 * https://leetcode-cn.com/problems/word-break/
 * 139. 单词拆分
 */
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        TreeSet<String> set = new TreeSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        //dp[i]: 字符串s[0~i]区间的字符可以被拆分
        // i-->[0~n]  j-->[0,i] j<i
        //dp[i] = dp[i] && sub(i,j);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (dp[j] && set.contains(subStr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
