package org.cc.leetcode.onehundred.thirsty;

import com.google.gson.Gson;
import org.cc.leetcode.util.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @ClassName : Num21
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 */
public class Num24 {
    public static void main(String[] args) {
        Num24 test=new Num24();
//        ListNode.printListNode();
//        int[] tar={-1,0,1,2,-1,-4};
//        int[] tar={3,-2,1,0};

        int[] tar1={ 3,0,-2,-1,17};
        ListNode res=test.swapPairs(ListNode.initListNode(tar1) );
        Gson gson=new Gson();
        System.out.println("swapPairs   "+gson.toJson(res));
    }

    public ListNode swapPairs(ListNode head) {
//        Gson gson=new Gson();
        if(head==null){
            return null;
        }else {
            Stack<Integer> stack=new Stack<>();
            ListNode node=new ListNode(0);
            ListNode ptr=node;
            int i=0;
            while (head!=null){
//                System.out.println("res   "+gson.toJson(ptr)+"i:"+i+" stack size:"+stack.size());
                if(i!=0&&i%2==0){//需要反转
                    node=covert(stack,node);
                }
                stack.push(head.val);
                head=head.next;
                i++;
            }
            if(!stack.empty()){
                node=covert(stack,node);
            }
            return  ptr.next;
        }

    }
    private ListNode covert(Stack<Integer> stack,ListNode tar){
//        System.out.println("*****************");  Gson gson=new Gson();
        ListNode n=null;
        while (!stack.empty()){
            int num=stack.pop();
//            System.out.println("pop num:"+num);
//            System.out.println("tar   "+gson.toJson(tar));
            n=new ListNode(num);
            tar.next=n;
            tar=tar.next;
        }
        return  tar;
    }

}



/****
 *
 输入：head = [1,2,3,4]
 输出：[2,1,4,3]
 示例 2：

 输入：head = []
 输出：[]
 示例 3：

 输入：head = [1]
 输出：[1]
 * */