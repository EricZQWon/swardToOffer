package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/25.
 */
public class Transform {
	public int calcCost(int A, int B) {
		// write code here
		int yu=A^B;
		int flag=1; int count=0;
		while (flag<yu){
			if((yu&flag)==flag)
				count++;
			flag=flag<<1;
		}
		return count;
	}

	public static void main(String[] args) {
		int a=19114,b=17568;
		Transform transform=new Transform();
		System.out.println(transform.calcCost(a,b));
	}
}
