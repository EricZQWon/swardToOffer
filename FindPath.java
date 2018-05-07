package SwardToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dell on 2018/1/3.
 */
public class FindPath {
	ArrayList<Integer> list=new ArrayList<>();
	ArrayList<ArrayList<Integer>> queue=new ArrayList<>();
	Stack<TreeNode> stack=new Stack<>();
	int count=0;
	//25ms 8.8K AC
	//终极蠢逼递归法。。。
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target,int k){


		if(root==null)
			return queue;
		list.add(root.val);
		if(root.left!=null)
			FindPath(root.left,target,1);
		if(root.right!=null)
			FindPath(root.right,target,1);
		if(root.left==null&&root.right==null){
			for(int i=0;i<list.size();i++){
				count+=list.get(i);
			}
			if(count==target) {
				queue.add(list);
				int temp=list.get(0);
				list=new ArrayList<>();
				list.add(temp);
			}
			if(list.size()!=1)
				list.remove(list.size()-1);
			count=0;
			root.val=-1;
		}
		if(root.left!=null&&root.right!=null){
			if((root.left.val==-1&&root.right.val==-1)){
				if(list.size()!=1)
					list.remove(list.size()-1);
			}
		}
		return queue;
	}
	//24ms 8.9K AC
	//更好的递归方法
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target,float k){
		if(root==null)
			return queue;
		list.add(root.val);
		target-=root.val;
		if(target==0&&root.left==null&&root.right==null)
			queue.add(new ArrayList<Integer>(list));
		FindPath(root.left,target,1.0f);
		FindPath(root.right,target,1.0f);
		list.remove(list.size()-1);
		return queue;
	}
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {



		if(root==null)
			return queue;
		stack.push(root);
		while (!stack.isEmpty())
		{
			TreeNode temp=stack.pop();
			list.add(temp.val);
			count+=temp.val;
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
			//到达叶子节点 左右子树均为空
			if(count==target&&temp.left==null&&temp.right==null) {
				queue.add(list);
			}
			list.remove(list.size()-1);
		}
		return queue;
	}

	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(5);
		TreeNode node3=new TreeNode(12);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(7);
//		TreeNode node6=new TreeNode(9);
//		TreeNode node7=new TreeNode(11);
		node1.left=node2; node1.right=node3;
		node2.left=node4; node2.right=node5;
//		node3.left=node6; node3.right=node7;
		FindPath path=new FindPath();
		ArrayList<ArrayList<Integer>> list=path.FindPath(node1,22,1.0f);
		System.out.println(list);
	}
}
