package SwardToOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dell on 2018/1/7.
 */
public class FirstNotRepeatingChar {
	//41ms 8.9K AC
	//想的太复杂了。。。思路是对的，键索引计数法没问题
	// 只比推荐弱智解法快10ms - -
	//牛客判题有问题，我
	public int FirstNotRepeatingChar(String str) {
		if(str=="") return -1;
		//键索引计数法
		char[] ch=new  char[256];

		ArrayList<Integer> list=new ArrayList<>();
		for(int index=0;index<str.length();index++){
			//这里判题出的问题，本地'\u0000'可以，OJ只能用0
			if(ch[str.charAt(index)]==0){
				//存放第一次的索引位置
				ch[str.charAt(index)]=(char)(index+1);
				list.add(index+1);
			}else {
				Integer i=(int)ch[str.charAt(index)];
				list.remove( i);
			}
		}
		return list.get(0)-1;
	}
	//23ms 8.8K AC
	//和上面思路一样 改写了一下
	public int FirstNotRepeatingChar(String str,int k){
		char[] ch=new char[128];
		for(int index=0;index<str.length();index++){
				ch[str.charAt(index)]+=1;
		}
		for(int index=0;index<str.length();index++){
			if(ch[str.charAt(index)]==1)
				return index;
		}
		return -1;
	}
	public static void main(String[] args) {
		String s="whhhhhswwwww";
		FirstNotRepeatingChar first=new FirstNotRepeatingChar();
		System.out.println(first.FirstNotRepeatingChar(s,1));
	}
}
