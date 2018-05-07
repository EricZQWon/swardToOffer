package SwardToOffer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dell on 2017/12/29.
 */
public class Convert {
	Stack<TreeNode> stack=new Stack<>();
	Stack<TreeNode> check=new Stack<>();


//双向链表的左边头结点和右边头节点
TreeNode leftHead = null;
TreeNode rightHead = null;
	//我不知道为什么这个AC不了 本地测试通过
	//成功AC，很gay 得把返回节点给它挪到最边上才行 三包服务真的是要。。。
	//21ms 8.7K AC
	public TreeNode Convert(TreeNode pRootOfTree,int k) {
		traverse(pRootOfTree);
		while (!stack.isEmpty())
		{
			check.push(stack.peek());
			if(stack.size()>=2)
				stack.pop().left=stack.peek();
			else
				stack.pop().left=null;
		}
		while (!check.isEmpty()){
			if(check.size()>=2)
				check.pop().right=check.peek();
			else
				check.pop().right=null;
		}
		for(;pRootOfTree.left!=null;pRootOfTree=pRootOfTree.left);
		return pRootOfTree;
	}
	public void traverse(TreeNode root){
		if(root==null)
			return;
		traverse(root.left);
		stack.push(root);
		traverse(root.right);
	}
	//20ms 8.6K AC
public TreeNode Convert(TreeNode pRootOfTree) {
//递归调用叶子节点的左右节点返回null
if(pRootOfTree==null) return null;
//第一次运行时，它会使最左边叶子节点为链表第一个节点
Convert(pRootOfTree.left);
if(rightHead==null){
leftHead= rightHead = pRootOfTree;
}else{
//把根节点插入到双向链表右边，rightHead向后移动
rightHead.right = pRootOfTree;
pRootOfTree.left = rightHead;
rightHead = pRootOfTree;
}
//把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
Convert(pRootOfTree.right);
//返回左边头结点
return leftHead;
}




	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(6);
		TreeNode node3=new TreeNode(14);
		TreeNode node4=new TreeNode(5);
		TreeNode node5=new TreeNode(7);
		TreeNode node6=new TreeNode(9);
		TreeNode node7=new TreeNode(11);
		node1.left=node2; node1.right=node3;
		node2.left=node4; node2.right=node5;
		node3.left=node6; node3.right=node7;
		Convert convert=new Convert();
		TreeNode root=convert.Convert(node1,1);
		for (;root.left!=null;root=root.left);
			for(;root!=null;root=root.right)
			System.out.println(root.val);
	}
}
