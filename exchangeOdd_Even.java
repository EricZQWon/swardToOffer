package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/26.
 */
public class exchangeOdd_Even {
	public int exchangeOddEven(int x) {
		// write code here
		int with=1;
		//定义奇偶位，true为奇数位
		boolean flag=true;
		int result=0;
		while (with<x){

			if((x&with)==with){
				//奇数位
				if(flag){
					result+=with*2;
				}else {
					result+=with/2;
				}
			}
			with*=2;
			flag=!flag;
		}
		return result;
	}
	public int better(int x){
		//32位int上偶数为1的数：0x55555555
		int odd=(x&0x55555555);
		//32位int上奇数为1的数：0xaaaaaaaa
		int even=(x&0xaaaaaaaa);
		return (odd<<1)|(even>>>1);

	}
	public static void main(String[] args) {
		int x=10;
		exchangeOdd_Even odd_even=new exchangeOdd_Even();
		System.out.println(odd_even.better(x));
	}
}
