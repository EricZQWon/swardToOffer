package SwardToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dell on 2018/1/23.
 */
public class BinaryTreeSerializable {
	//38ms 8.9K AC
	//细节考虑到就行
	//用-1和#代表空节点，用split方法分割节点，正则为\\s
	String Serialize(TreeNode root) {
		StringBuilder sb=new StringBuilder();
		//广搜bfs
		if(root==null) return sb.toString();
		LinkedList<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			TreeNode temp=queue.removeFirst();
			if(temp.val==-1)
				sb.append("#" + " ");
			else {
				sb.append(temp.val+" ");
				if(temp.left!=null) {
					queue.add(temp.left);
					//如果左孩子存在，则标志量为true
				}else {
					queue.add(new TreeNode(-1));

				}
				if(temp.right!=null) {
					queue.add(temp.right);
				}else {
					queue.add(new TreeNode(-1));

				}
			}
		}
		return sb.toString();
	}
	TreeNode Deserialize(String str) {
		String[] s=str.split("\\s");
		//第一个加入的肯定是根节点
		TreeNode root=new TreeNode(Integer.parseInt(s[0]));
		//当前重建到的节点
		TreeNode currentNode=root;
		//根据根节点以及序列化串重建二叉树
		int index=1;
		//标志量，代表当前是左子节点还是右子节点

		boolean swap=true;
		ArrayList<TreeNode> list=new ArrayList<>();
		ArrayList<Integer> visit=new ArrayList<>();
		list.add(root);
		for(;index<s.length-2;index++) {
			//左子节点
			if(swap){
				//如果不为空
				if(!s[index].equals("#")){
					currentNode.left=new TreeNode(Integer.parseInt(s[index]));
					list.add(currentNode.left);
				}else {
					currentNode.left=null;
				}

			}else {
				if(!s[index].equals("#")) {
					currentNode.right = new TreeNode(Integer.parseInt(s[index]));
					list.add(currentNode.right);
				}
				else {
					currentNode.right = null;
				}
				//挪到下一个节点
				list.remove(0);
				currentNode=list.get(0);
			}
			swap=!swap;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode node1=new TreeNode(5);
		TreeNode node2=new TreeNode(4);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(2);
		TreeNode node5=new TreeNode(7);
		TreeNode node6=new TreeNode(9);
		TreeNode node7=new TreeNode(11);
//		node1.left=node2;
		node1.right=node2;
//		node2.left=node4;
		node2.right=node3;
//		node3.left=node6;
		node3.right=node4;
		BinaryTreeSerializable serializable=new BinaryTreeSerializable();
		String s=serializable.Serialize(node1);
		String[] ss=s.split("\\s");
		for(String m:ss)
			System.out.println(m);
		TreeNode root=serializable.Deserialize(s);
	}
}
