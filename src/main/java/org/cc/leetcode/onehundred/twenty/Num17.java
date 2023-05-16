package org.cc.leetcode.onehundred.twenty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num17 {
    public static void main(String[] args) {
        Num17 test=new Num17();
//        ListNode.printListNode();
//        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};

String  str="23";
str="7";
        List<String> res=test.letterCombinations(str);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String text = gson.toJson(res);
        System.out.println("res   "+text);
    }
    String[] str=new String[]{"00","11","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private  Map<String,String> initMap(){
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i <10 ; i++) {
            map.put(i+"",str[i]);
        }
        return map;
    }
    public List<String> letterCombinations(String digits) {
        System.out.println("digits:"+digits);
        List<String> reslist=new ArrayList<>();
        if(digits==null||digits.length()==0){
            return reslist;
        }else if(digits.length()==1){
            String str= initMap().get(digits);
            char[] chaarr=str.toCharArray();
            for (int i = 0; i <chaarr.length ; i++) {
                reslist.add(chaarr[i]+"");
            }
        }else {
            Map<String,String> map=initMap();
            char[] chars=digits.toCharArray();
            int i=1;
            String[] temp=null;
            while(i<chars.length){
                String pre=chars[i-1]+"";
                String curr=chars[i]+"";
                System.out.println("pre is "+pre+" curr is "+curr);

                String a=map.get(pre);
                String b=map.get(curr);
                if(temp==null){//第一轮
                    temp= getArrByNum(a.toCharArray(),b.toCharArray());
                }else {
                    temp=getArrByNum(temp,b.toCharArray());
                }
                System.out.println("a is "+a+" b is "+b);
                i++;
            }
            reslist=Arrays.stream(temp).collect(Collectors.toList());
        }
        return  reslist;
    }
//num 2-9 组合
    private  String[]  getArrByNum(String[] a,char[] b){
        ArrayList<String> al=new ArrayList();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <b.length ; j++) {
                al.add(a[i]+b[j]);
            }
        }
        return al.stream().toArray(String[]::new);
    }
    private  String[]  getArrByNum(char[] a,char[] b){
        ArrayList<String> al=new ArrayList();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <b.length ; j++) {
                String s=(a[i]+""+b[j]);
                al.add(s);
                System.out.println("s:"+s);
            }
        }
        return  al.stream().toArray(String[]::new);
    }


    private void test(){
        String str="asd";
        char[] chars=str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]+"");
        }
        byte[] bytes=str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]+"");
        }
    }
}

/****
 *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * */