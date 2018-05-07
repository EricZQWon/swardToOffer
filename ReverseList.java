package SwardToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dell on 2017/12/27.
 */
public class ReverseList {
	ArrayList<Integer> list=new ArrayList<>();
	//暴力破解 23ms 8.7K AC
	public ListNode ReverseList(ListNode head) {
		for(ListNode node=head;node!=null;node=node.next){
			list.add(node.val);
		}
		ListNode node=head;
		for(int i=list.size()-1;i>=0;i--,node=node.next){
			node.val=list.get(i);
		}
		return head;
	}
	//最优解   19ms 8.7K AC
	public ListNode ReverseList(ListNode head,int k) {
		if(head==null)
			return null;
		//当前节点的前驱节点
		ListNode pre=null;
		//当前节点的后继节点
		ListNode next=null;
		//当前节点如果不为空 则继续遍历
		//反转链表
		while (head!=null)
		{
			//next保存当前节点的后继节点
			//避免在反转(即pre->head===》pre-<head)之后链式关系断裂
			next=head.next;
			//反转   pre->head->head.next(next)
			//		pre(head.next)<-head
			head.next=pre;

			pre=head;
			//移动到下一个节点
			head=next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		ListNode node4=new ListNode(5);
		node.next=node1; node1.next=node2;node2.next=node3; node3.next=node4;
		ReverseList list=new ReverseList();
		ListNode lnode=list.ReverseList(node);
		for(;lnode!=null;lnode=lnode.next){
			System.out.println(node.val);
		}
	}
}
