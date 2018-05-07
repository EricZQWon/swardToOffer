package Cracking_Coding_Interview;

import java.util.List;

public class Partition {
	//较小链表的头结点
	ListNode smallHead = new ListNode(-1);
	ListNode small = new ListNode(-1);
	//较大链表的头结点
	ListNode bigHead = new ListNode(-1);
	ListNode big = new ListNode(-1);
	public ListNode partition(ListNode pHead, int x) {
		smallHead.next = small;
		bigHead.next = big;
		for (ListNode node = pHead; node != null; node = node.next) {
			if (node.val < x) {
				if (small.val == -1)
					small.val = node.val;
				else {
					small.next = new ListNode(node.val);
					small = small.next;
				}
			} else {
				if (big.val == -1)
					big.val = node.val;
				else {
					big.next = new ListNode(node.val);
					big = big.next;
				}
			}
		}
		if (bigHead.next.val == -1)
			return smallHead.next;
		if (smallHead.next.val == -1)
			return bigHead.next;
		small.next = bigHead.next;
		return smallHead.next;
	}


	public static void main(String[] args) {
		ListNode node0 = new ListNode(6);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(8);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node0.next = node1;
		node1.next = node2;
//		node2.next = node3;
		node3.next = node4;
		ListNode node = new Partition().partition(node0, 9);
		for (ListNode test = node; test != null; test = test.next)
			System.out.println(test.val);
	}
}
