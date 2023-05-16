package org.cc.leetcode.onehundred.thirsty;

import com.google.gson.Gson;
import org.cc.leetcode.util.ListNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num25 {
    public static void main(String[] args) {
        Num25 test=new Num25();
//        ListNode.printListNode();

//        int[] tar1={ 3,0};
        int[] tar1={ 3,0,-2,-1,9,4,5,6,7,8};
        ListNode l1= ListNode.initListNode(tar1);
        ListNode.printListNode(l1);
        ListNode res=test.reverseKGroup(l1,2);

        Gson gson=new Gson();
        ListNode.printListNode(res);

        res=test.reverseKGroup2(ListNode.initListNode(tar1),2);
        ListNode.printListNode(res);
    }


//    链表中的节点数目为 n
//    1 <= k <= n <= 5000
//    0 <= Node.val <= 1000

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){//无意义直接返回原链表
            return head;
        }
        ListNode sumNode=new ListNode(0);
        ListNode curr=sumNode;

        ListNode n=head;
        Stack<ListNode>  stack=new Stack<>();
        int i=0;
        while (n!=null){
            if(i<k&&n!=null){
                stack.push(n);
                n=n.next;
                i++;
            }else if(i==k){
                while (!stack.empty()){
                    sumNode.next=stack.pop();
                    sumNode=sumNode.next;
                }
                sumNode.next=null;
                i=0;;

            }
//            else if(n==null&&!stack.empty()){//处理最后的剩余
//                Iterator<ListNode> value = stack.iterator();
//                while (value.hasNext()) {
//                    sumNode.next=value.next();
//                    sumNode=sumNode.next;
//                }
//                sumNode.next=null;
//            }
//            else {//i=k
//                while (!stack.empty()){
//                    sumNode.next=stack.pop();
//                    sumNode=sumNode.next;
//                }
//                i=0;
//                sumNode.next=null;
//            }


        }
        while (!stack.empty()) {
            Iterator<ListNode> value = stack.iterator();
            while (value.hasNext()) {
                ListNode tmp=value.next();
                sumNode.next = tmp;
                sumNode = sumNode.next;

            }
            stack.clear();
        }
            sumNode.next=null;

        return curr.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {

        ListNode sumNode=new ListNode(0);
        ListNode curr=sumNode;

        ListNode n=head;
        ListNode res=null;
        int i=0;
        while(n!=null){
            if(i<k&&n!=null){
                ListNode ln=new ListNode(n.val);
                ln.next=res;
                res=ln;
                n=n.next;
                i++;
//                ListNode.printListNode("res=",res);
            }else if(i==k||n==null){//结尾
                ListNode.printListNode("end",res);
                System.out.println("n="+n.val);
                while (sumNode.next!=null){
                    sumNode=sumNode.next;
                }//指针移动到末尾
                sumNode.next=res;
                i=0;
                res=null;
//                break;
            }
            while (sumNode.next!=null){
                sumNode=sumNode.next;
            }
            sumNode.next=n;
//            else {//该反转，或者最后
//
//                while (sumNode.next!=null){
//                    sumNode=sumNode.next;
//                }//指针移动到末尾
//                sumNode.next=res;
////                ListNode.printListNode("sum",sumNode);
//                i=1;
//                res=null;
//            }

        }
        return  curr.next;
    }

    //整体指针反转
    private  ListNode reverse(ListNode node){

        ListNode n=node;
        ListNode res=null;
        while(n!=null){
            ListNode ln=new ListNode(n.val);
            ln.next=res;
            res=ln;
            n=n.next;
        }
        return  res;
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