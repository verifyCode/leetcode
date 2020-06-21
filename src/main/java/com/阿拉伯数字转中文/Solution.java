package com.阿拉伯数字转中文;

/**
 * @author xjn
 * @since 2020-06-09
 */
public class Solution {
    private static final char[] data = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final char[] units = new char[]{'元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿'};

    private static String cov(String str) {
        int min = Integer.MAX_VALUE;
        StringBuffer sb = new StringBuffer(str);
        str = sb.reverse().toString()
                .replaceAll("零[拾佰仟]", "零")
                .replaceAll("零+万", "万")
                .replaceAll("零+元", "元")
                .replaceAll("零+", "零");
        return new StringBuffer(str).reverse().toString();
    }

    public static String convert(int money) {
        StringBuffer sbf = new StringBuffer();
        int unit = 0;
        while (money != 0) {
            sbf.insert(0, units[unit++]);
            int number = money % 10;
            sbf.insert(0, data[number]);
            money /= 10;
            System.out.println("number:" + number + " money:" + money);
        }
        System.err.println(sbf.toString());
        return sbf.toString();
    }

    public static void main(String[] args) {
        System.out.println(cov(convert(123)));
    }

}
