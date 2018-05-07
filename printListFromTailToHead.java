package SwardToOffer; /**
 * Created by dell on 2017/12/21.
 */


import java.util.ArrayList;
import java.util.Collections;

public class printListFromTailToHead {
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            for(ListNode node=listNode;node!=null;node= node.next){
                list.add(node.val);
            }

        }
        Collections.reverse(list);
        //遍历链表

        return list;
    }

   public  static  void main(String[] args){
        printListFromTailToHead print=new printListFromTailToHead();
        ListNode node=new ListNode(67);
        ListNode node1=new ListNode(0);
        ListNode node2=new ListNode(24);
        ListNode node3=new ListNode(58);
       node.next=node1; node1.next=node2;node2.next=node3;
       print.printListFromTailToHead(node);
   }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}