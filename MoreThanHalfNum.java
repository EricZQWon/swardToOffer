package SwardToOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dell on 2018/1/1.
 */
public class MoreThanHalfNum {
	//18ms 10K AC
	//最佳思路 攻守阵地思想
	//有多个守卫者，如果为0，则将当前数组索引值赋给守卫者
	//如果当前数组的值=守卫者的值，守卫者+1
	//如果不等 则是敌人来犯，一个同归于尽 守卫者-1
	public int MoreThanHalfNum_Solution(int [] array,double k){
		int result=0;
		int modCount=0;
		int size=0;
		for(int index=0;index<array.length;index++) {
			if (modCount == 0) {
				result=array[index];
				modCount=1;
			}
			if(array[index]==result) {
				modCount++;
			}
			else
				modCount--;
		}
		for(int i=0;i<array.length;i++){
			if (array[i]==result)
				size++;
		}
		return size>array.length/2?result:0;
	}
	//20ms 8.8K AC
	//  出现超过1/2次的数字=>array[length/2];
	//20ms 将数组排序，如果存在超过1/2的数字。那么必然数组长度1/2处索引的值是需要的值
	//再遍历一次数组，得到这个数字的出现次数，如果大于1/2则满足，否则不存在
	public int MoreThanHalfNum_Solution(int [] array,int k) {
		Arrays.sort(array);
		int mid=array[array.length/2];
		int count=0;
		for(int index=0;index<array.length;index++){
			if(array[index]==mid)
				count++;
		}
		return (count>(array.length/2))?mid:0;
	}
	//15ms 10.2K AC
	//暴力API  没什么好说
	public int MoreThanHalfNum_Solution(int [] array) {
		int length=array.length;
		if (length==1)
			return array[0];
		HashMap<Integer,Integer> hashMap=new HashMap<>();
		//遍历数组取得每个值
		for(int index=0;index<length;index++){
			if(!hashMap.containsKey(array[index]))
				hashMap.put(array[index],1);
			else {
				int x=hashMap.get(array[index]);
				if (x==length/2)
					return array[index];
				else
				hashMap.replace(array[index],++x);
			}
//			if(hashMap.size()>length/2)
//				return 0;
		}
		return 0;

	}

	public static void main(String[] args) {
		int[] array={1,2,3,2,2,2,5,4,2};
		MoreThanHalfNum more=new MoreThanHalfNum();
		System.out.println(more.MoreThanHalfNum_Solution(array,2.1));
	}

}
