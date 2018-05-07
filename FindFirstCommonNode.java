package SwardToOffer;

import java.util.ArrayList;

/**
 * Created by dell on 2017/12/22.
 */
public class FindFirstCommonNode {
    ArrayList<Integer> value = new ArrayList<>();

    //26ms 12k
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        for (ListNode node = pHead1; node != null; node = node.next) {
            value.add(node.val);
        }
        Integer[] query = value.toArray(new Integer[0]);

        for (ListNode node = pHead2; node != null; node = node.next) {
            for (int index = 0; index < query.length; index++)
                if (query[index].equals(node.val))
                    return node;
        }
        return null;
    }


    //26ms 8.8k
    public ListNode anotherOne(ListNode pHead1,ListNode pHead2){
        for(ListNode index1=pHead1;index1!=null;index1=index1.next)
            for(ListNode index2=pHead2;index2!=null;index2=index2.next){
                if(index1.val==index2.val)
                    return index2;
            }
            return null;
    }
    //24ms 8.4k
    public ListNode NotbestOne(ListNode pHead1,ListNode pHead2){
        for(ListNode node=pHead1;node!=null;node=node.next)
            value.add(node.val);
        for(ListNode node=pHead2;node!=null;node=node.next)
            if(value.contains(node.val))
                return node;
        return null;
    }
    public static void main(String[] args){
        FindFirstCommonNode find=new FindFirstCommonNode();
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(6);
        ListNode node3=new ListNode(7);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        node1.next=node2;   node2.next=node3;
        node4.next=node5;   node5.next=node6;
        node6.next=node7;
        System.out.println(find.FindFirstCommonNode(node1,node4).val);
    }
}
