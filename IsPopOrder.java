package SwardToOffer;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by dell on 2017/12/28.
 */
public class IsPopOrder {
	//20ms 8.8K AC
	//使用一个辅助栈记录
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> stack=new Stack<>();
		int popIndex=0;
		for(int index=0;index<pushA.length;index++){
			stack.push(pushA[index]);
			while (!stack.isEmpty()&&popA[popIndex]==stack.peek()){
				stack.pop();
				popIndex++;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		int[] pshA={1,2,3,4,5};
		int[] popA={5,4,3,2,1};
		IsPopOrder order=new IsPopOrder();
		System.out.println(order.IsPopOrder(pshA,popA));
	}
}
