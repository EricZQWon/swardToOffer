package SwardToOffer;

import java.util.ArrayList;

/**
 * Created by dell on 2018/1/6.
 */
public class GetUglyNumber {
	//最优解 暴力穷举太暴躁了。。。算不出来的
	//18ms 8.8K AC
	public int GetUglyNumber_Solution(int index) {
		if (index == 1) return 1;
		if(index==0) return 0;
        int[] x = new int[index];
		x[0] = 1;
		int w2 = 0, w3 = 0, w5 = 0;
		for (int i = 1;i < index; i++){
			int tmp2 = x[w2] * 2;
			int tmp3 = x[w3] * 3;
			int tmp5 = x[w5] * 5;
			int t = Math.min(tmp2, Math.min(tmp3, tmp5));
			//如果不更新w2,3,5的值的话，就会出现重复乘
//			比如开始是1  最小值是*2得到的2
//			这时候假如不更新值，那下一次还是1*(2,3,5
			if (t == tmp2) w2++;
			if (t == tmp3) w3++;
			if (t == tmp5) w5++;
			x[i]=t;
		}
		return x[index - 1];
	}
	public int GetUglyNumber(int index){
		int count=1;
		index--;
		while (index!=0){
			count++;
			int temp=count;
			while (temp%2==0)
				temp/=2;
			while (temp%3==0)
				temp/=3;
			while (temp%5==0)
				temp/=5;
			if(temp==1)
				index--;
		}
		return count;
	}

	public static void main(String[] args) {
		GetUglyNumber uglyNumber=new GetUglyNumber();
		System.out.println(uglyNumber.GetUglyNumber_Solution(1500));
	}
}
