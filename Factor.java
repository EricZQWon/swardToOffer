package Cracking_Coding_Interview;

public class Factor {
	public int getFactorSuffixZero(int n) {
		// write code here
		int result = 5;
		int count = 0;
		for (; n / result > 0; result *= 5) {
			count += n / result;
		}
		return count;
	}

	public static void main(String[] args) {
		Factor factor = new Factor();
		System.out.println(factor.getFactorSuffixZero(10));
	}
}
