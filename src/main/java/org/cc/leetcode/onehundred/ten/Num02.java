package org.cc.leetcode.onehundred.ten;

import org.cc.leetcode.util.ListNode;

/**
 * @ClassName : Num18
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 15:33
 *
 *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Num02 {
    public static void main(String[] args) {
        Num02 test=new Num02();
//        int[] arr=new int[]{2,7,11,15};
//        int target=9;

        int[] arr1=new int[]{2,4,3};
        int[] arr2=new int[]{5,6,4};
        ListNode l1=ListNode.initListNode(arr1);
        ListNode l2=ListNode.initListNode(arr2);
        test.addTwoNumbers(l1,l2);
        System.out.println("");
//        ListNode.printListNode();

    }


    private int filldata(ListNode node){
        int num=0;
        if(node!=null){
            num=node.val;
        }
        return num;
    }
//    思路，每一位相加，
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tempNode = res;
        int bignum = 0;//进位
        int temp = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int l1val = filldata(l1);
            int l2val = filldata(l2);
            temp = l1val + l2val;
            bignum = temp / 10;
            sum = temp % 10;
            ListNode n = new ListNode(sum);
            tempNode.next = n;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (bignum == 1) {//最后一位
            ListNode ln = new ListNode(bignum);
            tempNode.next = ln;
        }
        return res.next;
    }


}