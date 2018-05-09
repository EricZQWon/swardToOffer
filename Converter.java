package Cracking_Coding_Interview;


import java.util.ArrayList;
import java.util.List;

public class Converter {
	//创设链表的头结点
	ListNode head=new ListNode(-1);
	List<Integer> list=new ArrayList<>();
	public ListNode treeToList(TreeNode root) {
		ListNode node=new ListNode(-1);
		head.next=node;
		inTraverse(root);
		for (int index=0;index<list.size();index++){
			node.val=list.get(index);
			if (index!=list.size()-1) {
				node.next = new ListNode(-1);
				node = node.next;
			}
		}
		node.next=null;
		return head.next;
	}
	public void inTraverse(TreeNode root){
		if (root==null)
			return;
		inTraverse(root.left);
		list.add(root.val);
		inTraverse(root.right);
	}

	public static void main(String[] args) {
		TreeNode node1=new TreeNode(8);
		TreeNode node2=new TreeNode(6);
		TreeNode node3=new TreeNode(10);
		TreeNode node4=new TreeNode(5);
		TreeNode node5=new TreeNode(7);
		TreeNode node6=new TreeNode(9);
		TreeNode node7=new TreeNode(11);
		node1.left=node2; node1.right=node3;
		node2.left=node4; node2.right=node5;
		node3.left=node6; node3.right=node7;
		Converter converter=new Converter();
		ListNode head=converter.treeToList(node1);
		for (;head!=null;head=head.next)
			System.out.println(head.val);
	}
}
