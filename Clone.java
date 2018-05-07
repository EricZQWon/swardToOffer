package SwardToOffer;

/**
 * Created by dell on 2018/1/20.
 */
public class Clone {
	//26ms 8.9K AC
	public RandomListNode Clone(RandomListNode pHead)
	{
		RandomListNode listNode=new RandomListNode(pHead.label);
		RandomListNode head=listNode;
		for(;pHead!=null;pHead=pHead.next,listNode=listNode.next){
			listNode.label=pHead.label;
			if(pHead.random!=null)
			listNode.random=new RandomListNode(pHead.random.label);
			if(pHead.next!=null)
				listNode.next=new RandomListNode(pHead.next.label);

		}
		return head;
	}

	public static void main(String[] args) {
		RandomListNode node=new RandomListNode(1);
		RandomListNode node1=new RandomListNode(2);
		RandomListNode node2=new RandomListNode(3);
		RandomListNode node3=new RandomListNode(4);
		RandomListNode node4=new RandomListNode(5);
		RandomListNode node5=new RandomListNode(6);
		RandomListNode node6=new RandomListNode(7);
		node.next=node1;node1.next=node2;node2.next=node3;
		node3.next=node4;node4.next=node5;node5.next=node6;
		node.random=node;node1.random=node1;node2.random=node2;
		node3.random=node3; node4.random=node4;node5.random=node5;
		node6.random=node6;
		Clone clone=new Clone();
		RandomListNode res=clone.Clone(node);
		for(;res!=null;res=res.next)
		{

			System.out.println(res.label+" "+" "+res.random.label);

		}
	}
}
class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}