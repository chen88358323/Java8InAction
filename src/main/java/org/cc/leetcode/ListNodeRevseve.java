package org.cc.leetcode;

import com.google.gson.Gson;
import org.cc.leetcode.util.ListNode;

import java.util.Stack;

/**
 * @ClassName : ListNodeRevseve
 *
 * @Description :  链表反转
 * @param:
 * @Author : CC
 * @Date: 2023-05-05 22:00
 */
public class ListNodeRevseve {


    public static void main(String[] args) {
        ListNodeRevseve lnr=new ListNodeRevseve();
        int[] tar1={ 1,2,3,0,-2,-1,1,2};
        ListNode l1= ListNode.initListNode(tar1);
        //使用栈来做处理
        ListNode res=lnr.resevebyStack(l1);
        ListNode.printListNode(res);
        System.out.println("************");
        res=lnr.reseveListNode(ListNode.initListNode(tar1));
        ListNode.printListNode(res);

//        System.out.println("res   "+gson.toJson(res));
    }

    /***
     *
     * 使用栈来做处理
     * */
    private  ListNode resevebyStack(ListNode node){
        Stack<ListNode> stack =new Stack<>();
        while (node!=null){
            stack.push(node);
            node=node.next;
        }
        ListNode n=new ListNode(0);
        ListNode res=n;
        while (!stack.empty()){
            n.next=stack.pop();
            n=n.next;
        }
        n.next=null;
        return res.next;
    }


    //指针反转 1-》2——》3
    //编程    1<-2->3
    private  ListNode reseveListNode(ListNode n){
        ListNode head=n;
        ListNode temp=null;
        while (head!=null){
            ListNode node=new ListNode(head.val);
            node.next=temp;
            temp=node;//
            head=head.next;
        }
        return temp;
    }

}