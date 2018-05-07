package Cracking_Coding_Interview;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dell on 2018/1/27.
 */
public class BinInsert {
	public int binInsert(int n, int m, int j, int i) {
		int flag=1,temp=1,with=1,result=0;
		for(int x=0;x<j;x++){
			flag=flag<<1;
		}
		temp=flag;
		//记录j-i位上的01情况
		LinkedList<Integer> list=new LinkedList<>();
		for(int x=j;x<i;x++){
			//如果flag已经大于m了，证明从j-i之间全是0
				if(flag>m){
					list.add(0);
				}else {
					if((flag&m)==flag)
						list.add(1);
					else
						list.add(0);
				}
		}
		//计算0-j位上n的数值大小
		for(int x=0;x<j;x++){
			if((with&n)==with)
				result+=with;
			with=with<<1;
		}
		for(int x=j;x<i;x++){
			if(list.getFirst()==1)
				result+=temp;
			temp=temp<<1;
		}
		return result;
	}

	public static void main(String[] args) {
		BinInsert insert=new BinInsert();
		System.out.println(Integer.toBinaryString(1024));
		System.out.println(Integer.toBinaryString(19));
		System.out.println(insert.binInsert(1024,19,2,6));
	}
}
