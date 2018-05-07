package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/29.
 */
public class Successor {
	//标志量 是否找到节点
	boolean flag;
	TreeNode result;
	public int findSucc(TreeNode root, int p) {
		TreeNode result=inOrder(root, p);
		if(result==null) return -1;
		else
			return result.val;

	}
	public TreeNode inOrder(TreeNode root,int aim){
		if(root==null) return null;

		inOrder(root.left,aim);
		if(flag) {
			result=root;
			flag=false;
			return result;
		}
		if(root.val==aim) flag=true;
		inOrder(root.right,aim);
		return result;
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
		Successor successor=new Successor();
		System.out.println(successor.findSucc(node1,11));
	}
}
