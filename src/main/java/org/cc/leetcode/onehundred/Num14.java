package org.cc.leetcode.onehundred;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num14 {
    public static void main(String[] args) {
        Num14 test=new Num14();
//        ListNode.printListNode();
//        String[] strs =new  String[]{"flower","flow","flight"};
//        String[] strs =new  String[]{""};
        String[] strs =new  String[]{"reflower","flow","flight"};
        String res=test.longestCommonPrefix(strs);
        System.out.println("res   "+res);
    }
    public String longestCommonPrefix(String[] strs) {
        String res=null;
        //check condition
        if(strs==null||strs.length==0){
            return  "";
        }else  if(strs.length==1){
            return strs[0];
        }
        else {
//            int i=0;
//            while (i<strs.length){
//
//            }
            for (int i = 0; i <strs.length ; i++) {
                if(i+1== strs.length){
                    return res;
                }else {
                    res=getDuplicateStr(strs[i],strs[i+1]);
                    strs[i+1]=res;
                }
            }
            return res;
        }

    }
//亮亮别叫前缀
    String getDuplicateStr(String str1,String str2){
        if((str1==null)||(str2==null)){
            return "";
        }else {
            StringBuilder sb=new StringBuilder("");
            int l= str1.length()>str2.length()?str2.length(): str1.length();
            char[] str1Array=str1.toCharArray();
            char[] str2Array=str2.toCharArray();
            for (int i = 0; i < l; i++) {
                if(str1Array[i]==str2Array[i]){
                    sb.append(str1Array[i]);
                }else {
                    break;
                }
            }
            return sb.toString();
        }
    }
}



/****
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * */