package com.q93_restore_ip_addresses;

import java.util.List;

/**
 * @author xjn
 * @since 2020-01-31
 */
public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        int i = 0;
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        i++;
                        if(a + b + c + d == s.length())
                        System.out.println("a:" + a + " b:" + b + " c:" + c + " d:" + d);
                    }
                }
            }
        }
        System.out.println(i);
        return null;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        test.restoreIpAddresses("25525511135");

    }
}