package SwardToOffer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by dell on 2018/1/5.
 */
public class PrintTreeByZ {
	//30ms 11K AC
	//其他做法：利用Collections.reverse方法直接反转
	//或者利用LinkedList是双向链表的特点，直接往里加，加完根据奇偶层判定迭代器方向
	 public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
		ArrayList<Integer> list=new ArrayList<>();
		ArrayList<ArrayList<Integer>> queue=new ArrayList<>();
		LinkedList<TreeNode> travel=new LinkedList<>();
		Stack<TreeNode> travelStack=new Stack<>();
		//设定一个标志量 true代表是栈弹出
		boolean isStack=false;
		//当前访问的节点数
		int currentCount=0;
		//当前层含有的节点数,根节点为1，第一层初始
		int levelCount=1;
		//下一层含有的节点数,初始为根节点 所以有1个
		int nextLevelCount=0;
		if(pRoot==null)
			return queue;
		travel.add(pRoot);
		TreeNode temp=null;
		while (!travel.isEmpty()||!travelStack.isEmpty()){

			//如果当前层是正序
			if(!isStack){
				temp=travel.remove();
				list.add(temp.val);
			}else {
				//当前层是反序
				list.add(travelStack.pop().val);
				if(!travel.isEmpty())
				temp=travel.remove();
			}


			currentCount++;
			//将节点不空的左右子节点加入遍历序列
				if(temp.left!=null) {
					nextLevelCount++;
					//如果这一层是stack序列，即反序
						travel.add(temp.left);
						if(!isStack)
						travelStack.push(temp.left);

				}
				if(temp.right!=null) {
					nextLevelCount++;
					travel.add(temp.right);
					if(!isStack)
					travelStack.push(temp.right);
				}
				//这一层的节点已经访问完毕
			if(currentCount==levelCount){
				//方向置反
				isStack=!isStack;
				//把这一层节点加入序列
				queue.add(list);
				//进入下一层，当前访问节点归零
				currentCount=0;
				//把下一层节点赋给这一层
				levelCount=nextLevelCount;
				//下一层总节点数归零
				nextLevelCount=0;
				//统计列表清空，方便记录下一层
				list=new ArrayList<>();
			}
		}
		return queue;
	}
	//30ms 11K AC 五五开
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot,int K){
		ArrayList<Integer> list=new ArrayList<>();
		ArrayList<ArrayList<Integer>> queue=new ArrayList<>();
		//设定一个标志量 false代表是正序
		boolean isReverse=false;
		//当前访问的节点数
		int currentCount=0;
		//当前层含有的节点数,根节点为1，第一层初始
		int levelCount=1;
		//下一层含有的节点数,初始为根节点 所以有1个
		int nextLevelCount=0;
		if(pRoot==null)
			return queue;
		LinkedList<TreeNode> travel=new LinkedList<>();
		travel.add(pRoot);
		TreeNode temp=null;
		while (!travel.isEmpty()){
			temp=travel.remove();
			currentCount++;
			list.add(temp.val);
			if(temp.left!=null) {
				travel.add(temp.left);
				nextLevelCount++;
			}
			if(temp.right!=null) {
				travel.add(temp.right);
				nextLevelCount++;
			}
			if(currentCount==levelCount){

				if(isReverse)
					Collections.reverse(list);
				//把这一层节点加入序列
				queue.add(list);
				//方向置反
				isReverse=!isReverse;
				//进入下一层，当前访问节点归零
				currentCount=0;
				//把下一层节点赋给这一层
				levelCount=nextLevelCount;
				//下一层总节点数归零
				nextLevelCount=0;
				//统计列表清空，方便记录下一层
				list=new ArrayList<>();
			}
		}
		return  queue;
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
		PrintTreeByZ z=new PrintTreeByZ();
		ArrayList<ArrayList<Integer>> lists=z.Print(node1,1);
		System.out.println();
	}
}
