package org.cc.leetcode.onehundred;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/****
 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。


 示例 1：

 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 输出：[[1,5],[6,9]]
 示例 2：

 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 输出：[[1,2],[3,10],[12,16]]
 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 示例 3：

 输入：intervals = [], newInterval = [5,7]
 输出：[[5,7]]
 示例 4：

 输入：intervals = [[1,5]], newInterval = [2,3]
 输出：[[1,5]]
 示例 5：

 输入：intervals = [[1,5]], newInterval = [2,7]
 输出：[[1,7]]


 提示：

 0 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= intervals[i][0] <= intervals[i][1] <= 105
 intervals 根据 intervals[i][0] 按 升序 排列
 newInterval.length == 2
 0 <= newInterval[0] <= newInterval[1] <= 105
/**
 * https://leetcode.cn/problems/insert-interval/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num57 {
    public static void main(String[] args) {
        Num57 test=new Num57();
//        ListNode.printListNode();
//        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};

        //[[1,3],[2,6],[8,10],[15,18]]
        int[][] tar=test.init();
        int[] src=new int[]{2,5};

        int[][] res=test.insert(tar,src);
        Gson g=new Gson();
        System.out.println("res   "+g.toJson(res));

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
    private int[][] init(){
//        int[] a1=new int[]{1,3};
//        int[] a2=new int[]{2,6};
//        int[] a3=new int[]{8,10};
//        int[] a4=new int[]{15,18};
//        int[][] res=new int[][]{a1,a2,a3,a4};


//        int[] a1=new int[]{1,4};
//        int[] a2=new int[]{4,5};
//        int[][] res=new int[][]{a1,a2};

                int[] a1=new int[]{1,3};
        int[] a2=new int[]{6,9};
        int[][] res=new int[][]{a1,a2};
        return  res;
    }

    //判断两个数组是否有交集
    private boolean isContain(int[][] intervals,int[]sec){
        for (int i = 0; i < intervals.length; i++) {
            boolean  res=isContain(intervals[i],sec);
            if(res)
                return  res;
        }

        return  false;
    }
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

    private int[][] initArray(int[][] intervals, int[] newInterval){
        int[][] resArray=new int[intervals.length+1][];
        for (int i = 0; i < intervals.length ; i++) {
            resArray[i]=intervals[i];
        }
        resArray[intervals.length]=newInterval;
        Arrays.sort(resArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        return resArray;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        if(intervals!=null&&intervals.length==0){//只有一个不用排序直接返回
            return new int[][]{newInterval};
        }
        if(!isContain(intervals,newInterval)){
            //如果目标不在各个数组的交集中，直接增加，然后排序返回
           return  initArray(intervals,newInterval);
        }else {
            int[][] arrays=initArray(intervals, newInterval);
            for (int i = 0; i <arrays.length ; i++) {
                int next=i+1;
                if(next< arrays.length){
                    int[] fir=arrays[i];
                    int[] sec=arrays[next];
                    if(isContain(fir,sec)){//交集
                        int start=fir[0]<sec[0]?fir[0] :sec[0];
                        int end= sec[1]>fir[1]?sec[1] :fir[1];
                        int[] temp=new int[]{start,end};
                        arrays[next]=temp;
                        if(list.contains(fir))//合并，去除第一个
                            list.remove(fir);
                        if(!list.contains(temp))
                            list.add(temp);

                    }else {
                        if(!list.contains(fir)){
                            list.add(fir);
                        }
                        if(!list.contains(sec)){
                            list.add(sec);
                        }
                    }
                }
            }
            return convertList2Arr(list);
        }

    }
}


