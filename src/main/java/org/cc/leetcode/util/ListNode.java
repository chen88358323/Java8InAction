package org.cc.leetcode.util;

/**
 * @ClassName : ListNode
 * @Description :
 * @param:
 * @Author : CC
 * @Date: 2023-04-20 16:00
 *
 *
 * https://blog.csdn.net/qq_41437542/article/details/108768900
 */
public class ListNode {

    public int val ; // 节点的保存的内容
    public ListNode next = null;  //节点的引用，指向下一节点
    private ListNode head = null; //头节点
    public ListNode(int val)
    {
        this.val = val;
        this.head=this;
    }

    /*****
     *数据转化为ListNode
     */
    public static ListNode initListNode(int[] val) {
        ListNode node=new ListNode(0);
        node.head=node;
        if(val!=null&&val.length>0){
            for (int i = 0; i <val.length ; i++) {
                node.add(val[i]);
            }
        }else {
            return  null;
        }
        ListNode ln=node.next;
        ln.head=ln;
        return ln;
    }

    public static void printListNode(ListNode node) {
       if(node==null){
           System.out.println("printListNode: is null");
       }else {
           System.out.println("printListNode: ");
           while (node!=null){
               System.out.println(node.val);
               node=node.next;
           }
       }
    }



    public boolean add(int a) {  //添加新节点
        ListNode newNode = new ListNode(a);//实例化一个新节点a
        if (head == null) { //若头节点为空，新节点赋值给头节点
            head = newNode;
            return true;
        }
        ListNode cur = head;  //若头节点不为空，用cur代替head进行操作。防止修改head的值
        while (cur.next != null) { //遍历到最后一个节点
            cur = cur.next;
        }
        cur.next = newNode ; //让上一个节点的next指向新节点，完成连接
        return true;
    }
    public boolean delete(int a){ //删除指定节点
        if(head == null){  //若头节点为空，返回false
            return false;
        }
        if(head.val == a){
            head = head.next;
            return true;
        }
        ListNode cur = head; //用cur代替head进行操作。防止修改head的值（以下不再解释）
        while (cur.next != null){ //遍历所有节点
            if(cur.next.val == a){//对cur.next节点进行判断，如果是要删除的，直接让cur.next指向被删除节点的next节点。即为：cur.next = cur.next.next;
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int size(){  //返回节点长度
        int flag = 0;
        ListNode cur = head;
        while(cur != null){
            flag++;
            cur =cur.next;
        }
        return flag;
    }

    public int find(int a){  //查找节点，返回下标
        ListNode cur = head;
        int flag = 0;
        while(cur.next != null){
            if(cur.val != a){
                flag++;
                cur = cur.next;
            }
            return flag;
        }
        return -1;
    }

    public ListNode get(int x){ //用下标查找节点
        if(head == null){
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < x; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        if(head == null){
            return null;
        }
        while(cur != null) {
            ListNode tem = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tem;
        }
        return prev;
    }

}