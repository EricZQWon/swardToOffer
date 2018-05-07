package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/31.
 */
public class KthNumber {
	//原理和丑数一样
	public int findKth(int k) {
		if(k==0) return 0;
		if(k==1) return 1;
		int count_3=0,count_5=0,count_7=0;
		int[] count=new int[k+1];
		int result=0;
		count[0]=1;
		for(int x=1;x<k+1;x++){
			int temp_3=count[count_3]*3;
			int temp_5=count[count_5]*5;
			int temp_7=count[count_7]*7;
			result=Math.min(temp_3,Math.min(temp_5,temp_7));
			if(result==temp_3)
				count_3++;
			if(result==temp_5)
				count_5++;
			if(result==temp_7)
				count_7++;
			count[x]=result;
		}
		return count[k];
	}

	public static void main(String[] args) {
		int kth=3;
		KthNumber k=new KthNumber();
		System.out.println(k.findKth(kth));
	}
}
