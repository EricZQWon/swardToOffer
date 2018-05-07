package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/4/1.
 */
public class ListPlus {
	public ListNode plusAB(ListNode a, ListNode b) {
		// write code here
		//头结点
		ListNode first = new ListNode(-1);
		ListNode node = new ListNode(0);
		//上一个节点
		ListNode last = first;
		first.next = node;
		//记录上一位相加溢出的值
		int over = 0;
		for (; a != null || b != null || over != 0; last = last.next,
				node = node.next) {
			int valueA = 0, valueB = 0;
			if (a != null) {
				valueA = a.val;
				a = a.next;
			}
			if (b != null) {
				valueB = b.val;
				b = b.next;
			}
			if (node != null)
				node.val = valueA + valueB + over;
			node = new ListNode(valueA + valueB + over);
			last.next = node;

			//进位 设置溢出值
			if (valueA + valueB + over >= 10) {
				over = 1;
				node.val -= 10;
			} else
				over = 0;
		}
		return first.next;
	}

	public static void main(String[] args) {

	}
}
