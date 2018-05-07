package SwardToOffer;

/**
 * Created by dell on 2018/1/6.
 */
public class KthNode {
	//25ms 12K AC 可能递归比较影响性能吧 感觉已经很精简了
	TreeNode temp=null;
	int count=0;
	TreeNode KthNode(TreeNode pRoot, int k)
	{
		if(pRoot==null)
			return null;
		KthNode(pRoot.left,k);
		count++;
		if(count==k)
			temp=pRoot;
		KthNode(pRoot.right, k);
		return temp;
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
		KthNode k=new KthNode();
		System.out.println(k.KthNode(node1,3).val);
	}
}
