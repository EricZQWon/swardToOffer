package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/4/2.
 */
public class isBalancedTree {
	public boolean isBalance(TreeNode root) {
		// write code here
		int leftHeight = subHeight(root.left, 0);
		int rightHeight = subHeight(root.right, 0);
		if (Math.abs(leftHeight - rightHeight) >= 1)
			return false;
		else
			return true;
	}

	public int subHeight(TreeNode root, int height) {
		if (root != null)
			height += 1;
		else
			return 0;
		subHeight(root.left, height);
		subHeight(root.right, height);
		return height;
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
//		node1.right=node3;
		node2.left = node4;
		node2.right = node5;
//		node3.left=node6; node3.right=node7;
		System.out.println(new isBalancedTree().isBalance(node1));
	}
}
