package Cracking_Coding_Interview;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 现有一些随机生成的数字要将其依次传入，请设计一个高效算法，
 * 对于每次传入一个数字后，算出当前所有传入数字的中位数。
 * (若传入了偶数个数字则令中位数为第n/2小的数字，n为已传入数字个数)。
 * <p>
 * 给定一个int数组A，为传入的数字序列，同时给定序列大小n，
 * 请返回一个int数组，代表每次传入后的中位数。保证n小于等于1000。
 */
public class Middle {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	int count = 0;

	public void Insert(Integer num) {
		if (count % 2 == 0) {
			maxHeap.offer(num);
			int swap = maxHeap.poll();
			minHeap.offer(swap);
		} else {
			minHeap.offer(num);
			int swap = minHeap.poll();
			maxHeap.offer(swap);

		}
		count++;

	}

	public int[] getMiddle(int[] A, int n) {
		int[] res = new int[n];
		AtomicInteger index = new AtomicInteger();
		Arrays.stream(A).forEach(
				i -> {
					Insert(i);
					res[index.getAndIncrement()] = count % 2 == 0 ?
							maxHeap.peek() : minHeap.peek();
				}
		);
		return res;
	}

	public static void main(String[] args) {
		int[] A = {236312, 116289, 257841, 40359, 21993, 121674, 68768, 288444, 98015, 118071, 130963, 221777, 71589, 233048, 89053, 20048, 264772, 141943, 170253, 299901, 193849, 211453, 198250, 280383, 126656, 4775, 229057, 119532};
		Middle middle = new Middle();
		int[] res = middle.getMiddle(A, A.length);
		Arrays.stream(res).forEach(System.out::println);
	}
}
