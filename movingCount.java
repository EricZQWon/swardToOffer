package SwardToOffer;

/**
 * Created by dell on 2018/1/19.
 */
public class movingCount {
	//15ms 8.5K AC
	//先遍历一遍 至少要满足门槛值
	//满足门槛值之后 因为是每次只能上下左右移动
	//所以满足要求的必须是抱团的，比如1-9,11就不行，因为中间隔了个10
	boolean[][] moving;
	public int movingCount(int threshold, int rows, int cols)
	{
		moving=new boolean[rows][cols];
		int Matching=0;
		//遍历数组
		moving[0][0]=true;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(isMatching(threshold, i, j)){
					moving[i][j]=true;
				}
			}
		}
		for(int i=0;i<rows;i++) {
			for (int j = 0; j <cols; j++) {
				if(moving[i][j]) {
					Matching++;
				}
			}
		}
		return Matching;
	}

	/**
	 *
	 * @param row 	行数，计算行的各位
	 * @param col	列数，计算列的各位
	 * @return	是否满足阈值要求
	 */
	public boolean isMatching(int threshold,int row,int col){
		int tempRow=row; int tempCol=col;
		while (row!=0){

			//求取余数
			threshold-=row%10;
			//求上一位余数
			row/=10;
			if(threshold<0)
				return false;
		}
		while (col!=0){
			threshold-=col%10;
			col=col/10;
			if(threshold<0)
				return false;
		}
		if(tempRow!=0||tempCol!=0)
			//写了这么长一串 其实就是判断虽然满足门槛值却是“孤立”/“浮空的”
			//比如要求的是1-28,29不满足（11），30满足门槛，但是它是孤立的，因为和其他的隔开了，就也不能到达
		if(((tempRow-1>=0)&&moving[tempRow-1][tempCol])||(tempCol-1>=0)&&moving[tempRow][tempCol-1])
		return true;
		else
			return false;
		return true;
	}

	public static void main(String[] args) {
		movingCount movingCount=new movingCount();
		System.out.println(movingCount.movingCount(15,20,20));
	}
}
