package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/28.
 */
public class MagicIndexI {
	public boolean findMagicIndex(int[] A, int n) {
		return binary(A,0,n-1);
	}
	public boolean binary(int[] a,int start,int end){
		int mid=(start+end)/2;
		//因为是升序数组 所以start mid  end中间的Mid不用检查，比如 1 3，中间肯定是2
		if(end-start>=1){
			return binary(a,start,mid)||binary(a,mid+1,end);
		}
		if(a[start]!=start||a[end]!=end)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		int[] a={0,1,3,5,6,9,11,13,15,18,19,22,25,27,30,33,35,37,38,39,41,43,44,45,46,49,51,54,57,60,62,63,64,65,66,68,71,72,73,75,78,81,82,83,85,86,87,90,91,93,95,98,99,100,101,103,105,106,109,112,114,116,117,120,122,125,128,131,133,135,136,139,142,144,145,147,148,151,154,157,158};
		MagicIndexI indexI=new MagicIndexI();
		System.out.println(indexI.findMagicIndex(a,81));
	}
}

