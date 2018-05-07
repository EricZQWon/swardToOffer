package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/31.
 */
public class getMaxSum {
	public int getMaxSum(int[] A, int n) {
		int count=0,max=-Integer.MAX_VALUE;
		for(int i=0;i<A.length;i++){
			if(count<0){
				count=A[i];
			}else {
				count+=A[i];

			}
			if(count>max) max=count;
		}
		return max;
	}

	public static void main(String[] args) {
		int [] a={1,2,3,-6,7,1};
		getMaxSum maxSum=new getMaxSum();
		System.out.println(maxSum.getMaxSum(a,a.length));
	}
}
