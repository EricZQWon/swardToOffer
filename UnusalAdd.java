package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/25.
 */
public class UnusalAdd {
	public int addAB(int A, int B) {
		int temp;
		while (B!=0){
			temp=A^B;
			B=(A&B)<<1;
			A=temp;
		}
		return A;
	}
}
