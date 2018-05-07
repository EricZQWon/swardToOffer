package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/25.
 */
public class Max {
	//牛逼 只想到要用&和移位运算 具体怎么用毫无头绪
	public int getMax(int a, int b) {
		//隐形得到a,b谁更大；
		//如果a大，a>b,则b是负数，最高位为1
		//如果b大，a<b,则b是正数，最高位为0
		b=a-b;
		//b>>31，移位运算
		//a>b,最高位为1，则b>>31=1,    a=a-0;
		//a<b,最高位为0，则b>>31=0,    a=a-[(a-b)&0]
		a-=b&(b>>31);
		return a;
	}
}
