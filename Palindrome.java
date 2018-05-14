package Cracking_Coding_Interview;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
/**
 * 判断回文链表
 */
=======
>>>>>>> 判断回文链表 采用递归回溯
public class Palindrome {
	List list = new ArrayList();
	volatile int count = 0;
	volatile boolean flag = true;

<<<<<<< HEAD
	//递归 AC
	//另一种思路，快慢双指针
=======
>>>>>>> 判断回文链表 采用递归回溯
	public boolean isPalindrome(ListNode pHead) {
		if (pHead == null)
			return true;
		list.add(pHead.val);
		flag = isPalindrome(pHead.next);
		if (!list.get(count).equals(pHead.val)) {
			return false;
		}
		count++;
		return flag;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Palindrome palindrome = new Palindrome();
		System.out.println(palindrome.isPalindrome(node));
	}
}
