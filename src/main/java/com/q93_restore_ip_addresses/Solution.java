package com.q93_restore_ip_addresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xjn
 * @since 2020-01-31
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 93. 复原IP地址
 */
public class Solution {

    private List<String> resList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        resList.clear();
        if (s == null || s.length() == 0) {
            return resList;
        }
        restoreIpAddresses(s, 0, new LinkedList<>(), new LinkedList<>());
        return resList;
    }

    private void restoreIpAddresses(String ipStr, int pos, List<String> cur, List<String> ans) {
        if (cur.size() == 4) {
            System.out.println(cur);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            String segment = ipStr.substring(pos, pos + i);
            cur.add(segment);
            restoreIpAddresses(ipStr, pos + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.restoreIpAddresses("255 255 111 35");
    }
}
