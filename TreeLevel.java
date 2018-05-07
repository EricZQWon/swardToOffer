package Cracking_Coding_Interview;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by dell on 2018/1/29.
 */
public class TreeLevel {
	ListNode head=new ListNode(-1);
	ListNode traverse=head;
	public ListNode getTreeLevel(TreeNode root, int dep) {
		//头结点

		if(root==null||dep<=0) return null;
		if(dep==1){
			traverse.next=new ListNode(root.val);
			traverse=traverse.next;
		}else {
			getTreeLevel(root.left,dep-1);
			getTreeLevel(root.right,dep-1);
		}
		return head.next;
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
		TreeLevel level=new TreeLevel();
		ListNode head=level.getTreeLevel(node1,3);
		for(;head!=null;head=head.next){
			System.out.println(head.val);
		}
	}
}
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}
