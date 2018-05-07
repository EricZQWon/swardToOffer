package SwardToOffer;

/**
 * Created by dell on 2017/12/29.
 */
public class Merge {
	ListNode temp=null;
	//关键点：归并 递归 分治思想
	//20ms 8.8K AC
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1==null)
			return list2;
		else if(list2==null)
			return list1;
		else if(list1==null&&list2==null)
			return  null;
		if(list1.val<=list2.val){
			temp=list1.next;
			list1.next=list2;
			Merge(temp,list2);
		}else {
			temp=list2.next;
			list2.next=list1;
			Merge(list1,temp);
		}
		return list1.val<=list2.val?list1:list2;
	}

	public static void main(String[] args) {
		ListNode node=new ListNode(2);
		ListNode node1=new ListNode(4);
		ListNode node2=new ListNode(1);
		ListNode node3=new ListNode(3);
		node.next=node1;
		node2.next=node3;
		Merge merge=new Merge();
		ListNode root=merge.Merge(node,node2);
		for(;root!=null;root=root.next){
			System.out.println(root.val);
		}
	}
}
