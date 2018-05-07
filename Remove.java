package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/25.
 */
public class Remove {
	public boolean removeNode(ListNode pNode) {
		ListNode next=pNode.next;
		if(next==null) return false;
		else {
			next=pNode;
			pNode=null;
			return true;
		}
	}

	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2; node2.next=node3;
		Remove remove=new Remove();
		System.out.println(remove.removeNode(node2));

	}
}
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}