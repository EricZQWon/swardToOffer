package Cracking_Coding_Interview;

import java.util.ArrayList;

/**
 * Created by dell on 2018/4/2.
 */
public class checkBinarySearchTree {
	public boolean checkBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left != null && root.left.val > root.val)
			return false;
		if (root.left != null)
			if (root.left.right != null && root.left.right.val > root.val)
				return false;
		if (root.right != null && root.right.val < root.val)
			return false;
		if (root.right != null)
			if (root.right.left != null && root.right.left.val < root.val)
				return false;
		return checkBST(root.left) & checkBST(root.right);
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(9);
		TreeNode node7 = new TreeNode(11);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		System.out.println(new checkBinarySearchTree().checkBST(node1));
	}
}
