package org.cc.leetcode.onehundred;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num15 {
    public static void main(String[] args) {
        Num15 test=new Num15();
//        ListNode.printListNode();
        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};


        List<List<Integer>> res=test.threeSum(tar);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String text = gson.toJson(res);
        System.out.println("res   "+text);
    }

    private  void removeListNode(int i,List<Integer> tarlist){
        if(tarlist==null||tarlist.size()==0){
            return;
        }else {
            if(tarlist.indexOf(i)==0){
                tarlist.remove(0);
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resset=new HashSet<List<Integer>>();

        //search res list
        List<Integer> tarlist=Arrays.stream(nums).boxed().collect(Collectors.toList());

//        List<Integer> numslist=Arrays.stream(nums).boxed().collect(Collectors.toList());

        Arrays.stream(nums).boxed().collect(Collectors.toList());
//        int len=nums.length-1;
//        int[] temparra= Arrays.stream(nums).toArray();
        if(nums==null||nums.length<2){
            return  null;
        }else {
            for (int i = 0; i <nums.length-1 ; i++) {
                int fir=nums[i];
                int sen=nums[i+1];
                int thi=0-fir-sen;
                removeListNode(fir,tarlist);
                removeListNode(sen,tarlist);
                String res=findNum(tarlist,thi);
                if(res!=null&&!"".equals(res)){//建议使用StringUtils.isBlank()
                    System.out.println("thi:"+res);
                    thi=Integer.valueOf(res);
//                    dellistNode(numslist,thi);
                    ArrayList<Integer>  list=new ArrayList<>();
//                    if((fir!=sen&&sen!=thi&&thi!=fir)||(fir==sen&&sen==thi&&thi==fir&&fir==0)){
                        list.add(fir);
                        list.add(sen);list.add(thi);
                        Collections.sort(list);
                        resset.add(list);
//                    }

                }
            }
        }
        List<List<Integer>>  reslist=new  ArrayList<List<Integer>>(resset);
        return reslist;
    }
    //双指针查找数字
    private String findNum(List<Integer> list,int num){
        String res=null;
        //判断在外面做
        if(list==null||list.size()==0){

        }else if(list.size()==1){
            if(list.get(0)==num){
                return num+"";
            }
        }else {
            if(list.lastIndexOf(num)>-1){
                res=num+"";
                return  res;

            }
        }
        return res;
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



/****
 *
 *   private void dellistNode(List<Integer> list,int num){
 *         list.remove(0);
 * //        list.lastIndexOf()
 *     }
 *     public List<List<Integer>> threeSum(int[] nums) {
 *         Set<List<Integer>> resset=new HashSet<List<Integer>>();
 *         List<Integer> numslist=Arrays.stream(nums).boxed().collect(Collectors.toList());
 *         Arrays.stream(nums).boxed().collect(Collectors.toList());
 * //        int len=nums.length-1;
 * //        int[] temparra= Arrays.stream(nums).toArray();
 *         if(nums==null||nums.length<2){
 *             return  null;
 *         }else {
 *             for (int i = 0; i <nums.length-1 ; i++) {
 *                 int fir=nums[i];
 *                 int sen=nums[i+1];
 *                 int thi=0-fir-sen;
 *                 dellistNode(numslist,fir);
 *                 String res=findNum(numslist.stream().toArray(Integer[]::new),thi);
 *                 if(res!=null&&!"".equals(res)){//建议使用StringUtils.isBlank()
 *                     System.out.println("thi:"+res);
 *                     thi=Integer.valueOf(res);
 *                     //dellistNode(numslist,thi);
 *                     int[] resArr=new int[]{fir,sen ,thi};
 *                     ArrayList<Integer>  list=new ArrayList<>();
 *                     list.add(fir);
 *                     list.add(sen);list.add(thi);
 *                     Collections.sort(list);
 *                     resset.add(list);
 *                 }
 *             }
 *         }
 *         List<List<Integer>>  reslist=new  ArrayList<List<Integer>>(resset);
 *         return reslist;
 *     }
 *     //双指针查找数字
 *     private String findNum(Integer[] tar,int num){
 *         System.out.println("tar is "+tar);
 *         String res=null;
 *         //判断在外面做
 *         if(tar==null||tar.length==0){
 *
 *         }else if(tar.length==1){
 *             if(tar[0]==num){
 *                 return num+"";
 *             }
 *         }else {
 *             int sta =0;
 *             int end=tar.length-1;
 *             while (sta<end){
 *                 if(tar[sta]==num||tar[end]==num){
 *                     return  num+"";
 *                 }
 *                 sta++;
 *                 end--;
 *             }
 *         }
 *         return res;
 *     }
 * */