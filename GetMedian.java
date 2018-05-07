package SwardToOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by dell on 2018/1/1.
 */
public class GetMedian{
	//23ms 9.0K AC
	/**
	 * 凡和中位数/中间 有关的编程题，应当第一个考虑是否能将数据分成两部分，
	 * 一部分总比中间的数小，一部分总比中间的数大
	 * 这样中间值就很好求得
	 */

	//建立两个堆
	//最小堆存放的数都是大数，即堆中数据都比最小堆中的数据大
	//所以 中位数一定在两个堆顶之间
	//如果数据总数是偶数，则中位数=maxHeap.peek()+min/2;
	//如果总数是奇数，则中位数是小顶堆的堆顶

	//优先队列默认构造最小堆
	//采用自定义比较器可构造大顶堆
	PriorityQueue<Integer> maxHeap=new PriorityQueue<>(20, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	PriorityQueue<Integer> minHeap=new PriorityQueue<>();
	int count=0;
	public void Insert(Integer num) {
		if(count%2==0){
			maxHeap.offer(num);
			int swap=maxHeap.poll();
			minHeap.offer(swap);
		}else {
			minHeap.offer(num);
			int swap=minHeap.poll();
			maxHeap.offer(swap);

		}
		count++;

	}

	public Double GetMedian() {
		//数据总量是偶数

		return count%2==0?(minHeap.peek()+maxHeap.peek())/2.0:(double)minHeap.peek();
	}

	public static void main(String[] args) {
		int[] a={5,2,3,4,1,6,7,0,8};
		GetMedian median=new GetMedian();

		for(int i=0;i<a.length;i++){
			median.Insert(a[i]);
			System.out.println(median.GetMedian());
		}

	}



}

