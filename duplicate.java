package SwardToOffer;

import java.util.HashMap;

/**
 * Created by dell on 2017/12/27.
 */
public class duplicate {
	//19ms 8.9K AC
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		HashMap<Integer,Integer> hashMap=new HashMap<>();
		for(int index=0;index<length;index++){
			if(!hashMap.containsKey(numbers[index]))
				hashMap.put(numbers[index],1);
			else
			{
				duplication[0]=numbers[index];
				return true;
			}
		}
		return false;
	}
	//19ms 8.8K AC
	public boolean duplicate(int numbers[],int length,int [] duplication,int k){
		//最多会有N个数
		boolean[] temp=new boolean[length];
		for(int index=0;index<length;index++){
			//如果没被访问过 置为true
			if(temp[numbers[index]]==false)
				temp[numbers[index]]=true;
			//被访问过 return
			else{
				duplication[0]=numbers[index];
				return true;
			}

		}
		return false;
	}
	//19ms 8.8K AC 理论上最优解 空间复杂度O（1）
	public boolean duplicate(int numbers[],int length,int [] duplication,boolean k){

		for(int i=0;i<length;i++){
			int index = numbers[i];

			if (index >= length) {

				index -= length;

			}

			if (numbers[index] >= length) {
				duplication[0]=index;
				return true;

			}
			numbers[index] = numbers[index]+length;
		}
		return false;
	}
	public static void main(String[] args) {
		int[] array={2,3,1,0,2,5,3};
		int[] count=new int[1];
		duplicate duplicate=new duplicate();
		duplicate.duplicate(array,array.length,count,false);
		System.out.println(count[0]);
	}
}
