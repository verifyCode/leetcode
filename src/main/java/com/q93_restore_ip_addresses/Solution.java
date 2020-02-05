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
        restoreIpAddresses(s, 0, new LinkedList<>());
        return resList;
    }

    private void restoreIpAddresses(String s, int start, List<String> segment) {
        if (segment.size() == 4) {
            String ip = String.join("", segment);
            if (s.length() == ip.length()) {
                resList.add(String.join(".", segment));
            }
            return;
        }
        if (segment.size() > 4) {
            return;
        }
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String str = s.substring(start, i + 1);
            if (str.length() > 1 && str.startsWith("0")) {
                continue;
            }
            int temp = Integer.parseInt(str);
            if (temp > 255) {
                continue;
            }
            segment.add(str);
            restoreIpAddresses(s, i + 1, segment);
            segment.remove(segment.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //25525511135
        //2.5.5.25511135
//        solution.restoreIpAddresses("25525511135");
//        solution.restoreIpAddresses("0000");
        solution.restoreIpAddresses("010010");
    }
}
