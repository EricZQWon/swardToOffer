package Cracking_Coding_Interview;

public class Count2 {
	public int countNumberOf2s(int n) {
		// write code here
		int count = 0;
		int number = 1;
		//高位和低位
		int a, b;
		//分两种情况
		//1:当前位数上为2的
		//else
		for (; number <= n; number *= 10) {
			a = n / number;
			b = n % number;
			count += (a + 7) / 10 * number;
			if (a % 10 == 2)
				count += (b + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 20;
		Count2 count2 = new Count2();
		System.out.println(count2.countNumberOf2s(n));
	}
}
