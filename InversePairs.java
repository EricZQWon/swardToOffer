package SwardToOffer;

/**
 * Created by dell on 2018/1/21.
 */
public class InversePairs {
	int count;
	int[] temp;
	//逆序对的描述其实就是分割成有序数组，所以从排序上下手
	//因为是成对的比较 所以选择归并排序（第一次想到的是快排）

	public int InversePairs(int [] array) {
		int low=0; int high=array.length-1;
		temp=new int[array.length];
		merge(array,low,high);
		return count%1000000007;
	}
	//归并
	public void merge(int[] array,int lo,int high){
		if(lo>=high) return;
		int mid=(lo+high)>>1;
		merge(array,lo,mid);
		merge(array,mid+1,high);
		sort(array,lo,mid,high);
	}
	public void sort(int[] a,int lo,int mid,int hi){
		int i=lo,j=mid+1,k=0;
		while (i<=mid&&j<=hi){
			if(a[i]<a[j]){
				temp[k++]=a[i++];

			}else {
				//核心代码，如果ai>aj，则构成逆序对，而使用了归并排序，则i和i之后的数都一定大于aj
				//所以一共有mid-i+1(+1就是i本身)个
				temp[k++]=a[j++];
				count+=mid+1-i;
			}
		}
		while (i<=mid){
			temp[k++]=a[i++];
		}
		while (j<=hi){
			temp[k++]=a[j++];
		}
		for(int m=0;m<k;m++){
			a[lo+m]=temp[m];
		}
	}

	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7,0};
		InversePairs pairs=new InversePairs();
		System.out.println(pairs.InversePairs(a));
	}
}
