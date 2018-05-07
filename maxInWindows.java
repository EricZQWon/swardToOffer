package SwardToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dell on 2018/1/7.
 */
public class maxInWindows {
	//16ms 8.6K AC
	public ArrayList<Integer> maxInWindows(int [] num, int size)
	{
		LinkedList<Integer>  list=new LinkedList<>();
		ArrayList<Integer> queue=new ArrayList<>();
		int currentMax=0;
		for(int j=0;j<size;j++){
			list.add(num[j]);
			if(num[j]>currentMax)
				currentMax=num[j];
		}
		queue.add(currentMax);
		for(int index=size;index<num.length;index++){
			int temp=list.removeFirst();
			if(num[index]>currentMax)
				currentMax=num[index];
			list.add(num[index]);
			if(temp==currentMax){
				currentMax=list.getFirst();
				for(int i=1;i<list.size();i++){
					if(list.get(i)>currentMax)
						currentMax=list.get(i);
				}
			}
			queue.add(currentMax);
		}
		return queue;
	}

	public static void main(String[] args) {
		int[] a={2,3,4,2,6,2,5,1};
		maxInWindows windows=new maxInWindows();
		ArrayList<Integer> list=windows.maxInWindows(a,3);
	}
}
