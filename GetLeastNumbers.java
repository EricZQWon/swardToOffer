package SwardToOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by dell on 2018/1/8.
 */
public class GetLeastNumbers {
	//27ms 8.7k AC
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list=new ArrayList<>();
		if(k>input.length||input.length==0||k==0)
			return list;

		//最大堆的优先队列
		PriorityQueue heap=new PriorityQueue(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2) {
				return o2-o1;
			}
		});
		heap.add(input[0]);

		for(int index=1;index<input.length;index++)
		{
			//如果比最大堆堆顶元素小，将其加入堆，堆顶元素出堆
			if(heap.size()!=k)
				heap.offer(input[index]);
			else
				if(input[index]<(int)heap.peek())
				{
					heap.poll();
					heap.offer(input[index]);
				}

		}
		for(int i=0;i<k;i++)
		{
			list.add(0,(Integer) heap.poll());
		}
		return list;
	}

	public static void main(String[] args) {
		int[] a={4,5,1,6,2,7,3,8};
		GetLeastNumbers leastNumbers=new GetLeastNumbers();
		ArrayList<Integer> list=leastNumbers.GetLeastNumbers_Solution(a,0);
	}
}
