package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/26.
 */
public class Frequency {
	public int getFrequency(String[] article, int n, String word) {
		// write code here
		int count=0;
		for(int i=0;i<n;i++){
			if(article[i]==word)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		String[] s={"a","b","a","ab","abc"};
		int n=5;
		String word="a";
		Frequency frequency=new Frequency();
		System.out.println(frequency.getFrequency(s,n,word));
	}
}
