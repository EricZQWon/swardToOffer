package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/28.
 */
public class RobotI {
	public int countWays(int x, int y) {
		if(x==0||y==0) return 0;
		if(x==1||y==1) return 1;

		return countWays(x-1,y)+countWays(x,y-1);

	}

	public static void main(String[] args) {
		RobotI robotI=new RobotI();
		System.out.println(robotI.countWays(3,3));
	}
}
