package org.cc.leetcode;

/**
 * @ClassName : TwoSplite
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-27 09:12
 */
public class TwoSplite {
    public static void main(String[] args) {
//        int[] arr=new int[]{  -1,0,3,5,9,12};  9
//        int[] arr=new int[]{ -1,0,3,5,9,12};//2
        int[] arr=new int[]{ 5};//5
        TwoSplite ts=new TwoSplite();
        System.out.println(ts.splite(arr,5));
//        System.out.println(ts.search(arr,9));
    }
    /***
     * array 有序数组
     * target要找到的数字
     * */
    private  int splite(int[] array,int target){
        if(array==null||array.length==0){
            return -1;
        }else {
            int left=0;
            int right=array.length-1;
            while (left<=right){//=是解决单个的问题
                System.out.println(left+"   "+right);
                int mid=(right-left)/2+left;
                if(array[mid]==target){
                    return mid;
                }else if(array[mid]<target){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
            return -1;
        }
    }


//    public int search(int[] nums, int target) {
//
//        int l=0;
//        int r=nums.length-1;
//        while (l<=r){
//            System.out.println(l+"   "+r);
//            int mid=(r-l)/2+l;
//            if(nums[mid]==target){
//                return  mid;
//            }else if(nums[mid]<target){
//                l=mid;
//            }else {
//                r=mid;
//            }
//        }
//        return -1;
//
//    }

}