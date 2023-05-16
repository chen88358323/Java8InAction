package org.cc.leetcode.onehundred.twenty;

import com.google.gson.Gson;
import org.cc.leetcode.util.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class Num19 {
    public static void main(String[] args) {
        Num19 test=new Num19();
        ListNode listnode=test.initListNode();
        ListNode res=test.removeNthFromEnd2(listnode,2);
        Gson gson=new Gson();
        String text=gson.toJson(res);
        System.out.println("res   "+text);


    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        if(head!=null){
            ListNode tempnode=head,nnode=head;
            for (int i = 0; i <n ; i++) {
                nnode= nnode.next;
            }
            if(nnode==null){//删除头部
                return head.next;
            }
            while(nnode.next!=null){//nNODE移动到尾部
                tempnode=tempnode.next;
                nnode=nnode.next;
            }
            tempnode.next=tempnode.next.next;
        }
        return head;
    }

    //初始化样例数据
    private ListNode initListNode(){
//        int[] tar={-1,2,1,-4};
        int[] tar={1,2};
        ListNode node=new ListNode(0);
        ListNode head=node;
        for (int i = 0; i <tar.length ; i++) {
            ListNode n=new ListNode(tar[i]);
            node.next=n;
            node=node.next;
        }
        return  head.next;
    }
        //add by cc
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        else {
            ListNode temp=head;
            ListNode root=new ListNode(0);
            LinkedList<Integer> link=new LinkedList<>();
            int len=1;
            while (temp!=null){
                link.add(temp.val);
                if(temp.next!=null){
                    len++;

                }
                temp=temp.next;
            }
            link.remove(link.size()-n);//去掉指定的元素
            if(link.isEmpty()){
                return null;
            }else {
                temp=root;
                for (int val:link
                     ) {
                    ListNode node=new ListNode(val);
                    temp.next=node;
                    temp=temp.next;
                }
                return  root.next;
            }
        }

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