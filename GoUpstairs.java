package Cracking_Coding_Interview;

import java.util.stream.IntStream;

/**
 * Created by dell on 2018/4/3.
 */
public class GoUpstairs {
	int result = 0;

	public int countWays(int n) {
		// write code here
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] count = new int[n];
		count[0] = 1;
		count[1] = 1;
		count[2] = 2;
		for (int index = 3; index < n; index++) {
			for (int j = index; j >= 0; j--) {
				count[index] += count[j];
			}
		}
		IntStream.range(1, n).forEach(i -> result += count[i]);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new GoUpstairs().countWays(4));
	}
}
