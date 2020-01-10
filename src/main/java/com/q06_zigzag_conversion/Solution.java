package com.q06_zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * @author xjn
 * @since 2019-12-19
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        List<List<Character>> pList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Character> subList = new ArrayList<>();
            pList.add(subList);
        }
        char[] chars = s.toCharArray();
        char[][] auxArray = new char[numRows][];
        int x = 0;
        int y = 0;
        for (int i = 0; i < chars.length; i++) {
            if (x == 0) {
                for (int j = 0; j < numRows - 1; j++, i++) {
                    System.out.print("(" + x + "," + y + ")");
                    x++;
                }
                System.out.println();
            }
            for (int j = 0; j < numRows - 3; j++, i++) {
                x--;
                y++;
                System.out.print("(" + x + "," + y + ")");
            }

        }
        return "";
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int numRows = 4;
        String str = "12345679";
        test.convert(str,4);


    }
}
