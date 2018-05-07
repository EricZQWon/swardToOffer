package SwardToOffer;

import java.util.Arrays;

/**
 * Created by dell on 2018/1/3.
 */
public class isContinuous {
	public static void main(String[] args) {
		isContinuous continuous=new isContinuous();

		int[] array={0,0,0,3,0};
		System.out.println(continuous.isContinuous(array));
	}
	//15ms 11K AC
	public boolean isContinuous(int [] numbers) {
		Arrays.sort(numbers);
		int length=numbers.length;
		int count=0; int temp=0;
		for(int index=0;index<length-1;index++){

			//当前牌不是大小王
			if(numbers[index]!=0){
				if(numbers[index]==numbers[index+1])
					return false;
				count+=numbers[index+1]-numbers[index];
			}else {
				//大小王的数量
				temp=index+1;
			}
		}
		//数组中总数-大小王的数量，是数字的数量
		int number=length-temp;
		if(number==1)
			return true;
		//数字的间隔应该为number-1
		int gap=number-1;
		if(Math.abs(count-temp)==gap)
			return true;

		return false;
	}

}
