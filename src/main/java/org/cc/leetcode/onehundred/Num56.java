package org.cc.leetcode.onehundred;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/****
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 示例 1：

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：

 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


 提示：

 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 * */
/**
 * https://leetcode.cn/problems/merge-intervals/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num56 {
    public static void main(String[] args) {
        Num56 test=new Num56();
//        ListNode.printListNode();
//        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};

        //[[1,3],[2,6],[8,10],[15,18]]
        int[][] tar=test.init();

        int[][] res=test.merge(tar);
        Gson g=new Gson();
        System.out.println("res   "+g.toJson(res));

    }

    private int[][] init(){
//        int[] a1=new int[]{1,3};
//        int[] a2=new int[]{2,6};
//        int[] a3=new int[]{8,10};
//        int[] a4=new int[]{15,18};
//        int[][] res=new int[][]{a1,a2,a3,a4};


//        int[] a1=new int[]{1,4};
//        int[] a2=new int[]{4,5};
//        int[][] res=new int[][]{a1,a2};

                int[] a1=new int[]{1,4};
        int[] a2=new int[]{0,2};
        int[] a3=new int[]{3,5};
        int[][] res=new int[][]{a1,a2,a3};
        return  res;
    }

    //转换list为数组，以复合要求
    private int[][] convertList2Arr( List<int[]> l){
        if(l==null||l.size()==0){
            return null;
        }else {
            int[][] res=new int[l.size()][];
            for (int i = 0; i <l.size() ; i++) {
                res[i]=l.get(i);
            }
            return  res;
        }
    }
    //判断两个数组是否有交集
    private boolean isContain(int[] fir,int[]sec){
        int flen=fir[1]-fir[0];
        int slen=sec[1]-sec[0];
        if(flen>slen){//循环少的数组
            for (int i =fir[0]; i <fir[1]+1 ; i++) {
                if(i>=sec[0]&&i<=sec[1]){//存在交集
                    return true;
                }
            }
        }else {
            for (int i =sec[0]; i <sec[1]+1 ; i++) {
                if(i>=fir[0]&&i<=fir[1]){//存在交集
                    return true;
                }
            }
        }
        return  false;
    }
    public  int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        if(intervals!=null&&intervals.length==1){//只有一个不用排序直接返回
            list.add(intervals[0]);
            return convertList2Arr(list) ;
        }
        for (int i = 0; i <intervals.length ; i++) {
            int next=i+1;
            if(next<intervals.length){
                int[] firstArr=intervals[i];
                int[] secondArr=intervals[next];
                if(isContain(firstArr,secondArr)){//有交集，1.合并,2去除原来的
                    int start=firstArr[0]<secondArr[0]?firstArr[0]:secondArr[0];
                    int end =firstArr[1]>secondArr[1]?firstArr[1]:secondArr[1];
                    int[] temp=new int[]{start,end};
                    intervals[next]=temp;//更新，方便该节点和后面的合并
                    if(list.contains(firstArr)){
                        list.remove(firstArr);
                    }
                    if(!list.contains(temp))//去除
                        list.add(temp);
                }else {//无交集，增加
                    if(!list.contains(firstArr))
                        list.add(firstArr);
                    if(!list.contains(secondArr))
                         list.add(secondArr);
                }

            }else {

            }

        }
        return   convertList2Arr(list) ;
    }
}


