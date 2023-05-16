package org.cc.leetcode.onehundred.twenty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/
 *
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 */
//
//        解释：唯一可能的三元组和为 0 。
public class Num18 {
    public static void main(String[] args) {
        Num18 test=new Num18();
        int[] intarr=new int[]{1,2,34,5,0,-1};
        int tar=7;
        List<List<Integer>>  res=test.fourSum(intarr,tar);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String text = gson.toJson(res);
        System.out.println("res   "+text);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4){
            return null;
        }else {
            Arrays.sort(nums);


        }
        return null;

    }
}

/***
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 *
 * **/