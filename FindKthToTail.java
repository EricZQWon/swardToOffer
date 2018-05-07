package SwardToOffer;

import java.util.List;

/**
 * Created by dell on 2018/1/9.
 */
public class FindKthToTail {
	//我觉得我这个思路不差 将链表反转 再反向遍历
	//当然标答的适用性更强
	public ListNode FindKthToTail(ListNode head,int k) {
		//计数器 记录单链表长度
		int countLength=0;
		ListNode hNode=null;
		ListNode tail=null;
		//遍历单链表 并实现链表反转
		for(ListNode temp=head;temp!=null;){

			ListNode count=temp.next;
			temp.next=hNode;
			hNode=temp;
			temp=count;
			countLength++;
		}
		if(k>countLength)
			return null;
		for(;k>1;--k){
			hNode=hNode.next;
		}
		ListNode result=new ListNode(hNode.val);

		return result;
	}
	public ListNode FindKthToTail(ListNode head,int k,float b) {
		ListNode pre = null, p = null;

p = head;
pre = head;
int a = k;

		int count = 0;

		while (p != null) {
			p = p.next;
			count++;
			if (k < 1) {
				pre = pre.next;
			}
			k--;
		}
		if (count < a) return null;
		return pre;
	}
	public static void main(String[] args) {
		FindKthToTail toTail=new FindKthToTail();
		ListNode node=new ListNode(1);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		ListNode node4=new ListNode(5);
		node.next=node1; node1.next=node2;node2.next=node3;
		node3.next=node4;
		System.out.println(toTail.FindKthToTail(node,1,0.4f).val);
	}
}
