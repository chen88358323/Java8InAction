package org.cc.leetcode.onehundred;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/****
 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个下标。



 示例 1：

 输入：nums = [2,3,1,1,4]
 输出：true
 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 示例 2：

 输入：nums = [3,2,1,0,4]
 输出：false
 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


 提示：

 1 <= nums.length <= 3 * 104
 0 <= nums[i] <= 105
/**
 * https://leetcode.cn/problems/jump-game/description/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num55 {
    public static void main(String[] args) {
        Num55 test=new Num55();
//        ListNode.printListNode();
//        int[] tar={1,0,1,2,1,4};
        int[] tar={2,3,1,1,4};

        //[[1,3],[2,6],[8,10],[15,18]]

     boolean res=test.canJump(tar);
        Gson g=new Gson();
        System.out.println("tar:   "+g.toJson(tar));
        System.out.println("res is "+res);

    }
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return  true;
        }else {
            int skip=0;
            int curr=0;
            for (int i = 0; i < nums.length; i++) {
                if( (nums[i]+i)>=nums.length){
                    return  true;
                }else {
                    i=nums[i]+i;
                }
            }

        }
        return  false;
    }
}


