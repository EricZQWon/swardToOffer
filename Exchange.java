package Cracking_Coding_Interview;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by dell on 2018/1/25.
 */
public class Exchange {
	//核心思想 使得一个索引下包含了两个数值
	//然后使用抵消的方法，比如异或，加后减
	//异或的方法
	public int[] exchangeAB(int[] AB) {
		AB[0]=AB[0]^AB[1];//AB[0]=0^1,AB[1]=1;
		AB[1]=AB[0]^AB[1];//AB[1]=(0^1)^1=0;
		AB[0]=AB[0]^AB[1];//AB[0]=(0^1)^0=1;
		return AB;
	}
	//加法
	public int[] exchangeAB(int[] AB,int k) {
		AB[0]=AB[0]+AB[1];
		//此时0处是a0+a1
		AB[1]=AB[0]-AB[1];//结果是a0
		AB[0]-=AB[1];//a0+a1-a0=a1;
		return AB;
	}
	public static void main(String[] args) {
		int[] ab={1,2};
		Exchange exchange=new Exchange();
		int[] b=exchange.exchangeAB(ab);
		for(int i:b)
			System.out.println(i);
	}
}
