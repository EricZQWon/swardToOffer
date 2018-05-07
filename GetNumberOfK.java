package SwardToOffer;

/**
 * Created by dell on 2017/12/25.
 */
public class GetNumberOfK {
	//18ms 8.7K AC
	public int GetNumberOfK(int [] array , int k) {
		//二分查找思路
		int low=0;int high=array.length-1;
		int mid=0;
		//相等元素索引上下界
		int less=0,more=0;
		//是否找到的标志量

		boolean find=false;
		//统计 出现的次数
		int count=0;
		while (low<=high){
			mid=(low+high)/2;
			//证明在左边
			if(array[mid]>k)
				high=mid-1;
			else if(array[mid]<k)
				low=mid+1;
			else if(array[mid]==k) {
				find=true;
				break;
			}
		}
		//找到了
		if(find==true){
			int left=mid-1,right=mid;
			while (left>=0||right<array.length-1){
				if(left!=-1&&array[left]==k) {
					count++;
					left--;
				}else
					left=-1;
				if(right!=array.length&&array[right]==k){
					count++;
					right++;
				}else
					right=array.length;
			}
		}
			return count;
	}
	public int betterOne(int[] array,int k){
		//二分查找思路
		int low=0;int high=array.length-1;
		int mid=0;
		//相等元素索引上下界
		int less=high,more=low;
		//是否找到的标志量
		int count=0;
		//统计 出现的次数
		while (low<=high){
			mid=(low+high)/2;
			//证明在左边
			if(array[mid]>k)
				high=mid-1;
			else if(array[mid]<k)
				low=mid+1;
			else if(array[mid]==k) {
				if(mid<less) {
					less = mid;
					high=mid-1;
				}
				if(mid>more)
					more=mid;
					low=mid+1;
			}
		}
		return more-less;
	}
	public static void main(String[] args) {
		GetNumberOfK get=new GetNumberOfK();
		int[] array={1,2,3,3,3,3};
		System.out.println(get.betterOne(array,3));
	}
}
