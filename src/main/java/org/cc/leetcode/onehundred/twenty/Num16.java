package org.cc.leetcode.onehundred.twenty;

import java.util.*;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num16 {
    public static void main(String[] args) {
        Num16 test=new Num16();
//        ListNode.printListNode();
//        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};
//        0,1,2
        int[] tar={-1,2,1,-4};
//-4 -1 1 2
        int text=test.threeSumClosest(tar,1);
        System.out.println("res   "+text);


    }


    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3){
            return  0;
        }
//        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
//        System.out.println("["+nums.toString()+"]");
        Map<Integer,Integer> map=new HashMap<>();//key 距离 val 是三数之和
        int l,r=0;
        int juli,sum=0;
        int lastsum=nums[0]+nums[1]+nums[2];
        int[] array=new int[]{nums[0],nums[1],nums[2]};
        int lastjuli=Math.abs(target-lastsum);

        int len=nums.length;
        for (int i = 0; i < len-2; i++) {
            l=i+1;
            r=len-1;
            while(l<r){
                sum=(nums[i]+nums[l]+nums[r]);
                System.out.println(nums[i]+" "+nums[l]+" "+nums[r]);

                juli=Math.abs( target-sum);//获取距离绝对值
                if(lastjuli>juli){//
                    array =new int[]{nums[i],nums[l],nums[r]};
                    lastjuli=juli;
                }

//                lastjuli=Math.min(juli,lastjuli);
//                map.put(juli,sum);
                if(l<r&&sum<target){
                    l++;
                }if(l<r&&sum>target){
                    r--;
                }
//                l++;
//                r--;
            }

        }
        return Arrays.stream(array).sum();
    }
}



/****
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * */