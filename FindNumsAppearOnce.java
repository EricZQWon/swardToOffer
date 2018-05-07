package SwardToOffer;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by dell on 2017/12/28.
 */
public class FindNumsAppearOnce {
	//小型数组测试性能不是特别影响 基于查找的
	//18ms 9.0K AC
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[],int k){
		LinkedList<Integer> list=new LinkedList<>();
		for(int index=0;index<array.length;index++){
			Integer temp=array[index];
			if(!list.contains(temp))
				list.add(temp);
			else if(list.contains(temp))
				list.remove(temp);
		}
		num1[0]=list.get(0);num2[0]=list.get(1);

	}
	//看到数字成对出现就想到应该是能抵消的。。。但是自己思维太狭窄了，只想到正负数相加抵消，没想到异或
	//关键点：数与自身做异或运算为0 会比上面的方法省空间 时间应该都是2n 这个应该更快一点
	//19ms 8.8K AC
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		int length= array.length;
		int result=0;
		//将数组每一位做异或运算，得到的结果就是两个只出现一次的异或运算的结果
		for(int index=0;index<length;index++){
			result^=array[index];
		}
		//既然只出现一次 那么必然两个值不相同，异或结果不为0，必有一位1/0
		//根据这个特点将数组分为两部分，每一部分包含一个所求的值+一部分“成对”出现的值（做异或后抵消）
		//求出这一位不同的 2进制的位置
		int index=1;
		//逐位做与运算，求得1的位置
		outer:
		while (index<=result){
			if((index&result)==index)
				break outer;
			else
				index<<=1;
		}
		for(int i=0;i<length;i++){
			if((array[i]&index)==index)
				num1[0]^=array[i];
			else
				num2[0]^=array[i];
		}
	}

	public static void main(String[] args) {
		int[] array={2,2,5,5,6,6,1,3};
		int[] num1=new int[1];
		int[] num2=new int[1];
		FindNumsAppearOnce appearOnce=new FindNumsAppearOnce();
		appearOnce.FindNumsAppearOnce(array,num1,num2);
		System.out.println(num1[0]+" "+num2[0]);
	}
}
