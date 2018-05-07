package SwardToOffer;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by dell on 2017/12/24.
 */
public class LastRemainingInLoop {
	int count=0;
	int remain=0;
	LinkedList<Integer> list=new LinkedList<>();

	//约瑟夫环问题 以前没学好 又不想用循环链表 把自己卡死了
	//14ms 1.04K AC
	public int bestOne(int n,int m){
		//更简洁 13ms 8.4K AC
		//思路和下面是一样的 利用地推公式 只是这个不递归 性能更好一点
		//f(n)=(f(n-1)+m)%n
		//f(1)=0
		 if(n==0)
            return -1;
		 	int i, r = 0;
		 	//进行n-2+1轮 即n-1轮淘汰操作得到的结果
    		for (i = 2; i <= n; i++)
        		r = (r + m) % i;
			return r;

			//f(1)=0 这个没什么问题 编号从0开始，又只有一个人，不管m是多少 肯定就这个
		//递推公式:f(n)=(f(n-1)+m)%n
//			if(n < 1 || m < 1)
//				return -1;
//			if(n == 1){
//				return 0;
//			}
//			return (bestOne(n-1, m)+m)%n;
	}

	//38MS 8.7K AC
	public int LastRemaining_Solution(int n, int m) {
			if(n==0)
			return -1;
			for(int index=0;index<n;index++)
				list.add(index);
			remain=(m-1)% list.size();
					while(list.size()!=1){
						list.remove(remain);
						remain=(remain+(m-1))%list.size();
					}

			count=list.getFirst();
		return count;
	}

	public static void main(String[] args) {
		LastRemainingInLoop loop=new LastRemainingInLoop();
		System.out.println(loop.LastRemaining_Solution(5,3));
		System.out.println(loop.bestOne(5,3));
	}
}
