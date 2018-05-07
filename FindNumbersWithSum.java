package SwardToOffer;

import java.util.ArrayList;

/**
 * Created by dell on 2017/12/26.
 */
public class FindNumbersWithSum {

	ArrayList<Integer> list=new ArrayList<>();
	int index=0;
	//13ms 8.7k AC
	public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum,int k){
		if(array.length==0)
			return list;
		int min=0;
		while (min<=sum/2){
			min=array[index];
			int max=sum-min;
			int high=array.length-1;
			for(;array[high]>max;high--);
			if(array[high]==max){
				list.add(min);
				list.add(max);
				return list;
			}


			index++;
		}
		return list;
	}
	//17ms 12K AC    上榜 11ms
	public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
		if(array.length==0)
			return list;
		int min=0;
		while (min<=sum/2){
			min=array[index];
			int max=sum-min;
			if(getNumber(array,max)!=-1)
			{
				list.add(min);
				list.add(max);
				return list;
			}else{
				index++;
			}
		}
		return list;
	}
	//规定二分查找如果没找到 返回-1
	//找到了则返回key所对应array数组中的索引值
	public int getNumber(int[] array,int key){
		int low=0,high=array.length-1;
		int mid=0;
		while (low<=high){
			mid=(low+high)/2;
			if(array[mid]==key)
				return mid;
			else if(array[mid]>key)
				high=mid-1;
			else if(array[mid]<key)
				low=mid+1;
		}
		return -1;
	}

	public static void main(String[] args) {
		FindNumbersWithSum find=new FindNumbersWithSum();
		int[] array={1,2,4,7,11,15};
		ArrayList<Integer> list=find.FindNumbersWithSum(array,15,1);
		for(Integer e:list){
			System.out.println(e);
		}

	}
}
