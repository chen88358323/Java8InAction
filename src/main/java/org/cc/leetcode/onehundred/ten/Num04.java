package org.cc.leetcode.onehundred.ten;

/**
 * todo
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?languageTags=java
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 */
public class Num04 {
    public static void main(String[] args) {
        Num04 test=new Num04();
        int[] t1={1,2};
        int[] t2={3,4};
        test.findMedianSortedArrays(t1,t2);
//        ListNode.printListNode();

    }
    private double getMiddleNum(int[] tar){
        int len =tar.length;
        int num=len/2;
        int[] res;
        if(len%2>0){//奇数为
            System.out.println("res:"+tar[num]);
            return  Double.valueOf(tar[num]+"");
        }else{
            System.out.println("res:"+tar[num]+" and "+tar[num-1]);
            double d=(double)(tar[num]+tar[num-1])/2;
            return  d;
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double resd=0.0;
        if((nums1==null||nums1.length==0)&&(nums2==null||nums2.length==0)){
            return  resd;
        }else {//两个都为空的先不处理，处理两个都不为空
            int len1 = nums1.length - 1;
            int len2 = nums2.length - 1;
            int reslen = len1 + len2 + 1;
            int[] res = new int[reslen+1];
            //1.合并成一个数组
            while(reslen>-1){
                if(len1==-1){
                    res[reslen]=nums2[len2];
                    len2--;
                    reslen--;
                }else if(len2==-1){
                    res[reslen]=nums1[len1];
                    reslen--;
                    len1--;
                }else{
                    if (nums1[len1] >= nums2[len2]) {
                        res[reslen] = nums1[len1];
                        len1--;
                    } else {
                        res[reslen] = nums2[len2];
                        len2--;
                    }
                    reslen--;
                }
            }  //结果处理
            return getMiddleNum(res);
        }

    }
}
