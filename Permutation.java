package SwardToOffer;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dell on 2018/1/11.
 */
public class Permutation {
	//回溯法
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> list=new ArrayList<>();
		if(str.length()>0||str!=null) {
			dealWithString(str.toCharArray(),0,list);
			Collections.sort(list);
		}
		return list;
	}
	public void dealWithString(char[] chars,int i,ArrayList list){
		if(i==chars.length-1){
			String val=String.valueOf(chars);
			if(!list.contains(val))
			list.add(val);
		}
		else {
			for(int j=i;j<chars.length;j++){
				swap(chars,i,j);
				//递归 做全排序
				dealWithString(chars,i+1,list);
				//回溯到交换前的情况
				swap(chars,i,j);
			}
		}
	}
	public void swap(char[] ch,int i,int j){
		char temp=ch[i];
		ch[i]=ch[j];
		ch[j]=temp;
	}

	public static void main(String[] args) {
		String str="abc";
		Permutation permutation=new Permutation();
		ArrayList<String> list=permutation.Permutation(str);
		for(String s:list)
			System.out.println(s);
	}
}
