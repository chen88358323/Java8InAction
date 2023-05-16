package org.cc.leetcode.onehundred.thirsty;

import com.google.gson.Gson;
import org.cc.leetcode.util.ListNode;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * @ClassName : Num21
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num21 {
    public static void main(String[] args) {
        Num21 test=new Num21();
//        ListNode.printListNode();
//        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};

        int[] tar1={ 3,0,-2,-1,1,2};
        int[] tar2={ 1,5,5,8};
        ListNode res=test.mergeTwoLists(ListNode.initListNode(tar1),ListNode.initListNode(tar2));
        Gson gson=new Gson();
        System.out.println("res   "+gson.toJson(res));
    }

    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {

        ListNode n=new ListNode(0);
        ListNode root=n;
        while (n1!=null&&n2!=null){
            if(n1.val>=n2.val){
                n.next=n2;
                n2=n2.next;
            }else {
                n.next=n1;
                n1=n1.next;
            }
            n=n.next;
        }
        n.next=n1==null?n2:n1;
        return root.next;
    }

}



/****
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * */