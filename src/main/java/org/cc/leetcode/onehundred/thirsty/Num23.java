package org.cc.leetcode.onehundred.thirsty;

import com.google.gson.Gson;
import org.cc.leetcode.util.ListNode;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num23 {
    public static void main(String[] args) {
        Num23 test=new Num23();
//        ListNode.printListNode();


        ListNode res=test.mergeKLists(test.init2());
//        ListNode res=test.mergeKLists(test.init1());
        Gson gson=new Gson();
        System.out.println("res   "+gson.toJson(res));
    }
    private  ListNode[] init1(){
        int[] tar2={-1,0,1,2,-1,-4};
        int[] tar3={3,-2,1,0};
        int[] tar1={ 3,0,-2,-1,1,2};
        ListNode l1= ListNode.initListNode(tar1);
        ListNode l2= ListNode.initListNode(tar2);
        ListNode l3= ListNode.initListNode(tar3);
        ListNode[] nodes=new ListNode[]{l1,l2,l3};
        return nodes;
    }

    private  ListNode[] init2(){
        int[] tar2={1};
        int[] tar3={ 2};
        ListNode l2= ListNode.initListNode(tar2);
        ListNode l3= ListNode.initListNode(tar3);
        ListNode[] nodes=new ListNode[3];
        nodes[0]=l2;
        nodes[2]=l3;

        return nodes;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node=null;
        for (int i = 0; i < lists.length; i++) {
            node=merge2(node,lists[i]);
        }
        return   node;
    }

    public ListNode merge2(ListNode n1,ListNode n2) {

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
        n.next= n1==null?n2:n1;//加剩下的
        return root.next;

    }
}



/****
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 * */