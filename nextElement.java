package Cracking_Coding_Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by dell on 2018/1/27.
 */
public class nextElement {
	//O(n) 时间复杂度
	//思路：从后向前，最后一个肯定没有更大的，所以是-1
	//栈为空则加入-1
	//当前元素的值<栈顶元素，或者栈顶元素为-1的时候，跳出循环并赋值到copy中去。
	public int[] findNext(int[] A, int n) {
		Stack<Integer> stack=new Stack<>();
		stack.add(-1);
		int[] copy=new int[A.length];
		for(int i=A.length-1;i>=0;i--){
			if(stack.isEmpty()) stack.add(-1);
			while (stack.peek()!=-1&&stack.peek()<=A[i]) {
				copy[i] = stack.pop();
			}
			copy[i]=stack.peek();
			stack.push(A[i]);

		}
		return copy;
	}
	public int binarySearch(int[] a,int x){
		int low=0,high=a.length-1;
		while (low<=high){
			int mid=(low+high)/2;
			//在左边
			if(a[mid]>x){
				high=mid;
			}
			//x在右边
			else if(a[mid]<x){
				low=mid+1;
			}
			else
				if(mid!=a.length-1)
				return a[mid+1];
				else
					return -1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a={11,13,10,5,12,21,3};
		int n=7;
		nextElement nextElement=new nextElement();
		for(int i:nextElement.findNext(a,n))
			System.out.println(i);
	}
}
