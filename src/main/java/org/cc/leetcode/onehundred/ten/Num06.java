package org.cc.leetcode.onehundred.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?languageTags=java
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 */
public class Num06 {
    public static void main(String[] args) {
        Num06 test=new Num06();
//        ListNode.printListNode();
        String res=test.convert("PAYPALISHIRING",4);
        System.out.println("res   "+res);
    }
    public String convert(String s, int numRows) {
        if(s==null||s.length()==0){
            return null;
        }else if(numRows<3){
            return  s;
        }else {
            List<StringBuilder> sblist=new ArrayList<>(numRows);
            for (int i = 0; i < numRows; i++) {
                sblist.add(new StringBuilder());
            }
            int i=0,flag=-1;
            for (char b:s.toCharArray()
                 ) {
                sblist.get(i).append(b);
                if(i==0||i==numRows-1){
                    flag=-flag;
                }
                i+=flag;
            }
            StringBuilder builder=new StringBuilder();
            for (int j = 0; j <sblist.size() ; j++) {
                builder.append(sblist.get(j));
            }
            return  builder.toString();
        }
    }
}











//        if(numRows < 2) return s;
//        List<StringBuilder> rows = new ArrayList<StringBuilder>();
//        for(int i = 0; i < numRows; i++)
//            rows.add(new StringBuilder());
//        int i = 0, flag = -1;
//        for(char c : s.toCharArray()) {
//            rows.get(i).append(c);
//            if(i == 0 || i == numRows -1)
//                flag = - flag;
//            i += flag;
//        }
//        StringBuilder res = new StringBuilder();
//        for(StringBuilder row : rows) res.append(row);
//        return res.toString();