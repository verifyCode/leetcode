package com.q455_assign_cookies;

import java.util.Arrays;

/**
 * @author xjn
 * @since 2020-02-08
 * https://leetcode-cn.com/problems/assign-cookies/
 * 455. 分发饼干
 */
public class Solution {
    //胃口g[i]
    //饼干尺寸s[i]
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static void main(String[] args) {

    }
}
