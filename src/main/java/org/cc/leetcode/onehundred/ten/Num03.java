package org.cc.leetcode.onehundred.ten;

import java.util.HashSet;

/**
 * todo
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?languageTags=java
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Num03 {
    public static void main(String[] args) {
        Num03 test=new Num03();
        String str="asdfaasddfffgg";
        int res=test.lengthOfLongestSubstring(str);
        System.out.println("res :"+res);
//        ListNode.printListNode();

    }
    public int lengthOfLongestSubstring(String s) {
        int r = 0, l = 0, res = 0;
        HashSet<Character> set = new HashSet<>();
        while(r<s.length()){
            char c = s.charAt(r++);
            while(set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res,set.size());
        }
        return res;
    }


}