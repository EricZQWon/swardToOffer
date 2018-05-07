package SwardToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dell on 2018/1/4.
 */
public class PrintMinNumber {
	//19ms 13K AC
	public String PrintMinNumber(int [] numbers) {
		ArrayList<Integer> list= new ArrayList<>(numbers.length);
		for(int i=0;i<numbers.length;i++){
			list.add(numbers[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1=String.valueOf(o1);
				String s2=String.valueOf(o2);
				String str1=s1+s2;
				String str2=s2+s1;
				return str1.compareTo(str2);
			}
		});
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<numbers.length;i++){
			sb.append(list.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] test={5,4,3,2,1};
		PrintMinNumber minNumber=new PrintMinNumber();
		System.out.println(minNumber.PrintMinNumber(test));
	}
}
