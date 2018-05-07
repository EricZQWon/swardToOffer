package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/29.
 */
public class AntiOrder {
	int count;
	int[] temp;
	public int count(int[] A, int n) {
		int start=0,end=n-1;
		temp=new int[n];
		sort(A,start,end);
		return count;
	}
	public void sort(int[] a,int start,int end){
		if(start>=end) return;
		int mid=(start+end)/2;
		sort(a,start,mid);
		sort(a,mid+1,end);
		merge(a,start,end);
	}
	public void merge(int[] a,int lo,int high){
		int mid=(lo+high)/2;
		//index是归并辅助数组的索引位置
		int start=lo,end=mid+1,index=0;
		while (start<=mid&&end<=high){
			if(a[start]<a[end]){
				temp[index++]=a[start++];
			}
			//逆序对
			else {
				temp[index++]=a[end++];
				count+=(mid+1)-start;
			}
		}
		while (start<=mid){
			temp[index++]=a[start++];
		}
		while (end<=high)
			temp[index++]=a[end++];
		for(int i=0;i<index;i++){
			a[lo+i]=temp[i];
		}
	}

	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7,0};

		AntiOrder order=new AntiOrder();
		System.out.println(order.count(a,8));
	}
}
