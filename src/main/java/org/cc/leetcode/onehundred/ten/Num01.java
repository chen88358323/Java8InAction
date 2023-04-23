package org.cc.leetcode.onehundred.ten;

/**
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 *
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class Num01 {
    public static void main(String[] args) {
        Num01 test=new Num01();
//        int[] arr=new int[]{2,7,11,15};
//        int target=9;

        int[] arr=new int[]{3,2,4};
        int target=6;
        int[]  res=test.twoSum(arr,target);
        if(res==null){
            System.out.println("res is null");
        }else {
            for (int i = 0; i < res.length; i++) {

                System.out.print(res[i]);
            }
        }
    }


    public int[] twoSum(int[] nums, int target) {
        int[] res=null;
        if(nums.length<2){
            return  null;
        }
        else {
            for (int i = 0; i < nums.length ; i++) {
                int tar=target-nums[i];
                int end=nums.length-1;
                int sta=i+1;
                while(sta<=end){
                    if(tar==nums[sta]){
                        res=new int[]{i,sta};
                        return res;
                    }else if(tar==nums[end]){
                        res=new int[]{i,end};
                        return res;
                    }else {
                        sta++;
                        end--;
                    }
                }
            }
            return  null;
        }
    }
}