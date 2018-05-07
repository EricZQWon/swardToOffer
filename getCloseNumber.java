package Cracking_Coding_Interview;

import java.util.Arrays;

/**
 * Created by dell on 2018/4/2.
 */
public class getCloseNumber {
	//题目保证两个数都存在
	public int[] getCloseNumber(int x) {
		int min = x - 1, max = x + 1;
		int xIndex = Integer.bitCount(x);
		while (Integer.bitCount(min) != xIndex)
			min--;
		while (Integer.bitCount(max) != xIndex)
			max++;
		int[] result = {min, max};
		return result;
	}

	public static void main(String[] args) {
		int x = 96502;
		System.out.println(Integer.toBinaryString(96502));
		System.out.println(Integer.toBinaryString(96505));
		int[] number = new getCloseNumber().getCloseNumber(x);
		Arrays.stream(number).forEach(System.out::println);
	}
}
