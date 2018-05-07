package Cracking_Coding_Interview;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dell on 2018/4/4.
 */
public class Joseph {
	public int getResult(int n, int m) {
		if (n == 0)
			return -1;
		int i, r = 0;
		//进行n-2+1轮 即n-1轮淘汰操作得到的结果
		for (i = 2; i <= n; i++)
			r = (r + m) % i;
		return r;
	}

	public int getResultII(int n) {
		//第一轮从2开始
		return joseph(n, 2);
	}

	public int joseph(int n, int m) {
		int temp = n % m == 0 ? n / m : n / m + 1;
		//可以开始反推位置了，因为下一轮就能确定位置
		if (temp < m + 1)
			return (temp - 1) * m + 1;
		int index = joseph(temp, m + 1);
		return (index - 2) * m + 1;

	}

	public static void main(String[] args) {
		System.out.println(new Joseph().getResultII(210));
	}
}
