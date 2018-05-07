package SwardToOffer;

/**
 * Created by dell on 2018/1/18.
 */
public class deleteDuplication{
	//27ms 11K AC
	public ListNode deleteDuplication(ListNode pHead)
	{
		//思路：利用新增的头结点和一个遍历节点
		ListNode first=new ListNode(-1);
		//头结点
		first.next=pHead;
		ListNode traverse=first;
		traverse.next=null;
		int cmp=-1;
		while (pHead!=null){
			//如果下一个节点和这个节点相同，则删除
			if(pHead.next!=null){
				if(pHead.next.val==pHead.val||pHead.val==cmp){
					cmp=pHead.val;
					pHead=pHead.next;
				}
				else {
					traverse.next=pHead;
					pHead=pHead.next;
					traverse=traverse.next;
					traverse.next=null;
				}
			}else {
				if(cmp!=pHead.val)
					traverse.next=pHead;
					pHead=pHead.next;
			}
		}
		return first.next;
	}

	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(1);
		ListNode node3=new ListNode(1);
		ListNode node4=new ListNode(1);
		ListNode node5=new ListNode(1);
		ListNode node6=new ListNode(1);
		ListNode node7=new ListNode(1);

		node.next=node1; node1.next=node2;node2.next=node3;
		node3.next=node4; node4.next=node5; node5.next=node6;
		node6.next=node7;
		deleteDuplication deleteDuplication=new deleteDuplication();
		ListNode res=deleteDuplication.deleteDuplication(node);
		for(ListNode listNode=res;listNode!=null;listNode=listNode.next){
			System.out.println(listNode.val);
		}
	}
}

