package SwardToOffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dell on 2017/12/26.
 */
public class GetNext {
	//26ms 8.9K AC 上榜时间:20ms 最快 15ms
	//		for(TreeLinkNode node:list){
//			if(node.val==temp){
//				int index=list.indexOf(node);
//				if(index<list.size()-1)
//				return list.get(list.indexOf(node)+1);
//				else
//					return null;
//
//			}
//		}
	//优化版本
	//24ms 8.9K AC
	ArrayList<TreeLinkNode> list=new ArrayList<>();
	boolean flag=false;
	int only=0;
	public TreeLinkNode GetNext(TreeLinkNode pNode)
	{
		int temp=pNode.val;
		TreeLinkNode root=getRoot(pNode);
		traverse(root,temp);

		if(list.size()==2)
			return list.get(1);

		return null;

	}

	//得到二叉树的根节点
	public TreeLinkNode getRoot(TreeLinkNode node){
		if(node.next!=null)
			node=getRoot(node.next);
		return node;
	}
	//中序遍历二叉树 将相应的节点和下一个节点加入List
	public  void traverse(TreeLinkNode root,int key){

		if(root!=null){
			traverse(root.left,key);
			if(root.val==key)
				flag=true;
			if(only<2&&flag) {
				list.add(root);
				only++;
				if(list.size()==2)
					return;
			}

			traverse(root.right,key);
		}
	}
	//按理说这个方法效率应该高一点，不知道为啥会差不多
	//最开始想的方案也是这样 只是在对第三种情况：没有右子树且不是父节点的左孩子的情况考虑不周
	//24ms 10.4K AC
	public TreeLinkNode GetNext(TreeLinkNode pNode,int k){
		if(pNode==null)
			return null;
		//如果节点的右子树不为空，则后继是右子树中最左的
		if(pNode.right!=null)
		{
			pNode=pNode.right;
			while (pNode.left!=null){
				pNode=pNode.left;
			}
			return pNode;
		}
		//如果右子树为空  有两种情况
		//节点是父节点的左孩子 则后继节点是父节点
		//如果是右孩子 就要顺着父节点一直往上直到当前节点是其父节点的左孩子
		while (pNode.next!=null){
			if(pNode.next.left==pNode)
				return pNode.next;
			pNode=pNode.next;
		}
		return null;
	}


	public static void main(String[] args) {
		TreeLinkNode node1=new TreeLinkNode(8);
		TreeLinkNode node2=new TreeLinkNode(6);
		TreeLinkNode node3=new TreeLinkNode(10);
		TreeLinkNode node4=new TreeLinkNode(5);
		TreeLinkNode node5=new TreeLinkNode(7);
		TreeLinkNode node6=new TreeLinkNode(9);
		TreeLinkNode node7=new TreeLinkNode(11);
		node1.left=node2; node1.right=node3;
		node2.left=node4; node2.right=node5;
		node3.left=node6; node3.right=node7;

		node2.next=node1; node3.next=node1;
		node4.next=node2; node5.next=node2;
		node6.next=node3; node7.next=node3;
		GetNext next=new GetNext();
 		System.out.println(next.GetNext(node7,1));
	}
}
class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}