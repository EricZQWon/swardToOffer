package SwardToOffer;

import java.util.ArrayList;

/**
 * Created by dell on 2018/1/9.
 */
public class reConstructBinaryTree {
	//保存中序索引的位置
	ArrayList<Integer> list=new ArrayList<>();
	TreeNode totalRoot;
	//计数器 记录前序数组访问到了哪个点
	int count=0;
	//
	TreeNode tempRoot=null;
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		//上一个根节点在中序的索引位置
		int lastRootIndex=pre.length;


		//前序序列第一个元素是根节点
		TreeNode root=new TreeNode(pre[0]);
		totalRoot=root;
		for (int i=0;i<pre.length;i++){
			for(int j=0;j<in.length;j++){
				if(pre[i]==in[j])
					list.add(j);
			}
		}
		return iterate(root,list.get(count),list.get(count+1),in,lastRootIndex);
	}
	//递归 接收根节点 和根节点的索引
	public TreeNode iterate(TreeNode root,int rootIndex,int subIndex,int[] in,int lastRootIndex){
		TreeNode tempRoot=null;
		TreeNode temp=new TreeNode(in[subIndex]);

		if(root==null)
			return null;
		//是左子节点
		if(subIndex<rootIndex){
			//中序中该节点的值
			root.left=temp;
			lastRootIndex=rootIndex;
			count++;
			if(count<in.length-1)
				tempRoot=iterate(temp, subIndex, list.get(count + 1), in, lastRootIndex);
		}
		if(tempRoot!=null)
			subIndex=tempRoot.val;
		if(subIndex>lastRootIndex&&lastRootIndex!=list.get(0))
			return new TreeNode(subIndex);
		else if(subIndex>rootIndex){
			root.right=temp;
			lastRootIndex=rootIndex;
			count++;
			if(count<in.length-1)
				tempRoot=iterate(temp, subIndex, list.get(count + 1), in, lastRootIndex);
			return tempRoot;
		}



		return root;
	}

	public static void main(String[] args) {
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		reConstructBinaryTree binaryTree=new reConstructBinaryTree();
		TreeNode root=binaryTree.reConstructBinaryTree(pre,in);
	}
}
