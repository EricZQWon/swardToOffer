package SwardToOffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dell on 2017/12/24.
 */
public class isSymmetrical {
	/*思路：
		对称二叉树的遍历方式最好是后序遍历
		一般是左右中
		但如果是对称的，左右中和右左中得到的遍历序列应该是一样的
	* */
	//17ms 8.7K AC
	ArrayList<Integer> list=new ArrayList<>();
	ArrayList<Integer> arrayList=new ArrayList<>();
	public boolean isSymmetrical(TreeNode pRoot){
		if(pRoot==null)
			return true;
		//得到后序遍历的序列 存放在list中
		traverse(pRoot);
		inTraverse(pRoot);
		for(int index=0;index<list.size();index++){
			if(list.get(index)!=arrayList.get(index))
				return false;}

		return true;
	}
	public void traverse(TreeNode root){
		//规定遇到空子树的时候用-1代替
		if(root==null) {
			list.add(-1);
			return;
		}
		traverse(root.left);
		traverse(root.right);
		list.add(root.val);
	}
	public void inTraverse(TreeNode root){
		if(root==null) {
			arrayList.add(-1);
			return;
		}
		inTraverse(root.right);
		inTraverse(root.left);
		arrayList.add(root.val);
	}

	public static void main(String[] args) {
		TreeNode node1=new TreeNode(5);
		TreeNode node2=new TreeNode(5);
		TreeNode node3=new TreeNode(5);
		TreeNode node4=new TreeNode(5);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(5);
		TreeNode node7=new TreeNode(5);
		node1.left=node2; node1.right=node3;
		node2.left=node4; node3.right=node5;
		node4.left=node6; node5.left=node7;
		isSymmetrical isSymmetrical=new isSymmetrical();
		System.out.println(isSymmetrical.isSymmetrical(node1));
	}
}
