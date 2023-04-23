package org.cc.leetcode.onehundred.ten;

/**
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num09 {
    public static void main(String[] args) {
        Num09 test=new Num09();
//        ListNode.printListNode();
//        int res=test.myAtoi("4193 with words");
//        int res=test.myAtoi("words and 987");
//        int res=test.myAtoi( "3.14159");
//        int res=test.myAtoi("-91283472332");
        boolean res=test.isPalindrome(1221);
        System.out.println("res   "+res);
    }
    public boolean isPalindrome(int x) {
        boolean res=true;
        if(x<0){
            return false;
        }else if(x<10){
            return true;
        }else {
            String ste=x+"";
            char[] charArr=ste.toCharArray();
            for (int i = 0,j=charArr.length-1; i <j ; i++,j--) {
                if(charArr[i]!=charArr[j]){
                    res=false;
                }
            }
        }
        return res;
    }
}



/****
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 * */