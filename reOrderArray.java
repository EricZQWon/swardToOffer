package SwardToOffer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by dell on 2018/1/5.
 */
public class reOrderArray {
	//14ms 10K AC
	//空间和时间均不理想
	public void reOrderArray(int [] array) {
		//遍历一次数组 得到奇数和偶数的数量
		//O(n)
		int[] a= Arrays.copyOf(array,array.length);
		int odd=0,count=0;
		for(int index=0;index<array.length;index++){
			if((array[index]&1)==1)
				odd++;
		}
		//再遍历一次数组
		for(int index=0;index<array.length;index++)
		{
			if((a[index]&1)==1) {
				array[count] = a[index];
				count++;
			}
			else
			{
				array[odd]=a[index];
				odd++;
			}
		}
	}
	public void reOrderArray(int [] array,int k){
		int odd=0;
		for(int index=0;index<array.length;index++){
			//奇数
			if((array[index]&1)==1)
			{
				int temp=array[index];

				//从odd处到index-1处，所有元素（都是偶数）向后挪动一个位置
				for(int i=index;i>odd;i--){
					array[index]=array[index-1];
				}
				array[odd+1]=array[odd];
				array[odd]=temp;
				odd++;
			}
		}

	}
	public static void main(String[] args) {
		int[] a={1,3,5,6,8,9,2,4};
		reOrderArray orderArray=new reOrderArray();
		orderArray.reOrderArray(a,1);
		System.out.println();
	}
}
