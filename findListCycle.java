package SwardToOffer;

import java.util.HashMap;

/**
 * Created by dell on 2017/12/23.
 */
public class findListCycle {
    //经典算法：快慢指针
    //应用：寻找单链表中的环，有序链表中的中位数
    //关键点:两个指针，一快一慢，快指针移动的速度是慢指针的两倍
    //时间复杂度：O（n），最坏情况，循环整个链表才找到环
    //11ms 13K AC
    public ListNode bestOne(ListNode pHead){
        if(pHead==null||pHead.next==null)
            return null;
        /*
            用while做循环的话两个节点的初始值就是phead
            如果用for做循环，因为是判定后移动，所以初始值要赋值成这样
        * */
        ListNode fast=pHead.next.next;
        ListNode less=pHead.next;
        for(;fast!=null&&fast.next!=null;fast=fast.next.next,less=less.next)
        {
            if(less==fast)
            {
                fast=pHead;
                while (less!=fast){
                    less=less.next;
                    fast=fast.next;
                }
                if(less==fast)
                return less;
            }
        }
        return null;
    }
    public ListNode antherOne(ListNode pHead){
    if(pHead == null || pHead.next == null)
            return null;
    ListNode p1 = pHead;
    ListNode p2 = pHead;
        while(p2 != null && p2.next != null ){
        p1 = p1.next;
        p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                    while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                    }
                    if(p1 == p2)
                return p1;
            }
}
return null;
    }
    //用Hashmap存储链表的节点，顺序遍历链表，如果出现两次，证明是有环的，第一次出现的节点就是环的起点
    //感觉也不是太暴力弱智，18ms 8800k AC
    HashMap<ListNode,Integer> hashMap=new HashMap<>();
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        //遍历单链表 找到环/遍历结束 退出
        for(ListNode index=pHead;index!=null;index=index.next){
            if(hashMap.containsKey(index))
                return index;
            else
                hashMap.put(index,index.val);
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);

        node.next=node1; node1.next=node2;node2.next=node3;
        node3.next=node4; node4.next=node2;
        findListCycle find=new findListCycle();
        System.out.println(find.antherOne(node).val);
        System.out.println(find.bestOne(node).val);
    }
}
