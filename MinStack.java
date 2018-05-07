package SwardToOffer; /**
 * Created by dell on 2017/12/21.
 */
import java.util.Arrays;
import java.util.Stack;
public class MinStack {
    Stack<Integer> stack=new Stack<>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
     Integer[] mins=stack.toArray(new Integer[0]);
     Arrays.sort(mins);
       return mins[0];
    }
    public static  void  main(String[] args){
        MinStack minStack=new MinStack();
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(4);
        System.out.println(minStack.min());
        minStack.push(2);
        System.out.println(minStack.min());

    }
}
