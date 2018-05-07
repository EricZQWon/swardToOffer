package Cracking_Coding_Interview;

import java.util.Stack;
import java.util.stream.IntStream;

public class Parenthesis {
	//括号匹配序列非递归基本操作，使用栈空间判断
	Stack<Character> stack = new Stack<>();

	public boolean chkParenthesis(String A, int n) {
		for (int index = 0; index < A.length(); index++) {
			if (A.charAt(index) == '(')
				stack.push('(');
			else {
				if (stack.size() == 0) {
					return false;
				} else
					stack.pop();
			}
		}
		//如果出了循环，stack还有(，证明多了，不完全匹配
		return stack.size() == 0;
	}

	public static void main(String[] args) {
		String str = "()a()()";
		Parenthesis parenthesis = new Parenthesis();
		System.out.println(parenthesis.chkParenthesis(str, 6));
	}
}
