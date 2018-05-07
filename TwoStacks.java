package Cracking_Coding_Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TwoStacks {
	//题目要求 使用双栈对数组进行排序(升序)
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		// write code here
		//排序栈
		Stack<Integer> order = new Stack<>();
		//存放最小元素的栈
		Stack<Integer> min = new Stack<>();
		Arrays.stream(numbers).forEach(
				(i) -> {
					//如果排序栈为空 直接入栈
					if (order.size() == 0) {
						order.push(i);
					} else {
						//当前栈中最大元素为栈顶
						int max = order.peek();
						if (max <= i)
							order.push(i);
						else {
							//将i挪到order中比它大的元素之前
							while (order.size() != 0 && order.peek() > i) {
								int temp = order.pop();
								min.push(temp);
							}
							order.push(i);
							while (min.size() != 0)
								order.push(min.pop());
						}
					}
				}
		);
		ArrayList<Integer> list = new ArrayList<>();
		while (order.size() != 0)
			list.add(order.pop());
		return list;
	}

	public static void main(String[] args) {
		int[] n = {2, 1, 4, 4, 5};
		TwoStacks twoStacks = new TwoStacks();
		List list = twoStacks.twoStacksSort(n);
		list.stream().forEach(System.out::println);
	}
}
