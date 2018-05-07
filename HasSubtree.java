package SwardToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dell on 2018/1/8.
 */
public class HasSubtree {
	ArrayList<TreeNode> result=new ArrayList<>();
//	20ms 8.7K AC
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if(root1==null)
			return false;
		//找到A树中与B树根节点相同的点
		ArrayList<TreeNode> temp=findTheSame(root1,root2);
		//如果没找到 肯定不是A树的子结构
		if(temp.size()==0)
			return false;
		//设定是否是子结构的标志量
		boolean flag=false;
		//将相同的节点都检验一遍:
		while (!temp.isEmpty()&&!flag){
			TreeNode tempRoot=result.remove(0);
			Stack<TreeNode> stack1=new Stack<>();
			Stack<TreeNode> stack2=new Stack<>();
			//将两个节点加入栈 进行DFS
			stack1.push(tempRoot); stack2.push(root2);
			while (!stack2.isEmpty()){
				if(stack1.isEmpty())
					return false;
				TreeNode check1=stack1.pop();
				TreeNode check2=stack2.pop();
				//如果两个节点不同 则不是子结构
				if(check1.val!=check2.val) {
					flag = false;
					break ;
				}
				else
					flag=true;
				if(check2.left!=null) {
					stack2.push(check2.left);
					if(check1.left!=null)
						stack1.push(check1.left);
				}
				if(check2.right!=null) {
					stack2.push(check2.right);
					if (check1.right!=null)
						stack1.push(check1.right);
				}

			}

		}
		return flag;
	}
	public ArrayList<TreeNode> findTheSame(TreeNode root,TreeNode found){
		if(root==null||found==null)
			return null;
		findTheSame(root.left,found);
		if(root.val==found.val) {
			result.add(root);
		}
		findTheSame(root.right,found);
		return result;
	}

	public static void main(String[] args) {
		TreeNode node1=new TreeNode(8);
		TreeNode node2=new TreeNode(0);
		TreeNode node3=new TreeNode(8);
		TreeNode node4=new TreeNode(0);
		TreeNode node5=new TreeNode(9);
		TreeNode node6=new TreeNode(0);
		TreeNode node7=new TreeNode(2);
		TreeNode node8=new TreeNode(0);
		TreeNode node9=new TreeNode(5);
		node1.left=node2; node1.right=node3;
		node2.left=node4; node2.right=node5;
		node4.left=node6; node4.right=node7;
		node7.left=node8; node7.right=node9;
		TreeNode root1=new TreeNode(8);
		TreeNode root2=new TreeNode(9);
		TreeNode root3=new TreeNode(2);
		TreeNode root4=new TreeNode(3);
		root1.right=root2; root2.left=root4;
		root2.right=root3;
		HasSubtree subtree=new HasSubtree();
		System.out.println(subtree.HasSubtree(null,root1));
	}
}
