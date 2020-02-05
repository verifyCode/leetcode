package com.q91_decode_ways;

/**
 * @author xjn
 * @since 2020-02-04
 * https://leetcode-cn.com/problems/decode-ways/
 * 91. 解码方法
 */
public class Solution {

    public int numDecodings(String s) {
        return numDecodingsRecursive(s);
    }

    private int numDecodingsRecursive(String s) {
        System.out.println("s:" + s);
        if (0 == s.length()) {
            return 0;
        }
        if (1 == s.length()) {
            int t = Integer.parseInt(s);
            if (t == 0) {
                return 0;
            }
            return 1;
        }
        String strTen = s.substring(0, 1);
        String strGe = s.substring(1, 2);

        int ten = Integer.parseInt(strTen);
        int ge = Integer.parseInt(strGe);
        int all = ten * 10 + ge;
        int res = 0;
        if (ten > 0 && ge > 0) {
            res += 1;
        } else if (all > 0 && all <= 26) {
            res += 1;
        }
        res += numDecodingsRecursive(s.substring(1, s.length()));
        System.out.println("strTen:" + strTen + "  strGe:" + strGe + "  res:" + res);
        return res;
    }



    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.println(test.numDecodingsRecursive("12"));
    }


}
