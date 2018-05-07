package SwardToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dell on 2018/1/2.
 */
public class PrintFromTopToBottom {
	//23ms 8.8K AC 我也不知道为啥这么慢
	//吐槽一下 这不就是层次遍历么 还不如我前面做的printTreeByLevlel.java
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

		LinkedList<TreeNode> list=new LinkedList<>();
		ArrayList<Integer> queue=new ArrayList<>();
		if (root==null)
			return queue;
		list.add(root);
		while (!list.isEmpty()){
			TreeNode temp=list.remove();
			queue.add(temp.val);
			if(temp.left!=null)
				list.add(temp.left);
			if (temp.right!=null)
				list.add(temp.right);

		}
		return queue;
	}
}
