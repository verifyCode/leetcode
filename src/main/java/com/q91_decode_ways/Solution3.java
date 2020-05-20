package com.q91_decode_ways;


/**
 * @author xjn
 * @since 2020-05-19
 */
public class Solution3 {
    /**
     * 定义状态转移方程:dp[i]  表示字符串s[0~i]的解码数量*
     *
     * s[i] == '0'
     *      #最后两位只能合并解码为10或者20,例如
     *      if(s[i-1] == 1 || s[i-1] == 2){
     *          dp[i] = dp[i-1]
     *      }else{
     *          return 0;
     *      }
     *s[i] != '0'
     *      if(s[i-1] == '1' || (s[i-1] == '2' && s[i] >= 1 && s[i] <= 6)){
     *          dp[i] = dp[i-1] + dp[i-2]
     *      }else{
     *          dp[i] = dp[i-1]
     *      }
     *
     * */



}