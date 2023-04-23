package org.cc.leetcode.onehundred.ten;

/**
 * todo
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?languageTags=java
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class Num05 {
    public static void main(String[] args) {
        Num05 test=new Num05();
        int[] t1={1,2};
        int[] t2={3,4};
        test.longestPalindrome("ssssssddsadafa");
//        ListNode.printListNode();

    }
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return null;
        }
        StringBuffer sb=new StringBuffer(s);
        String s2=sb.reverse().toString();
        for (int i = 0; i <s2.length() ; i++) {
            if(s.charAt(i)==s2.charAt(i)){

            }
        }
        return  null;
    }
}
