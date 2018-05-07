package SwardToOffer;

/**
 * Created by dell on 2018/1/17.
 */
public class FindInMatrix {
	public boolean Find(int target, int [][] array) {
		//左下角的的位置
		int rows=array.length-1;
		int cols=0;
		int limit=array[0].length;
		int temp=-100;
		while (rows>=0&&cols<limit){
			//从左下角出发搜索
			temp=array[rows][cols];
			//如果当前位置大于目标值 则向上移动
			if(temp>target){
				rows--;
			}else if(temp<target)
				cols++;
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] test={{1,2,8,9},{4,7,10,13}};
		int target=7;
		FindInMatrix find=new FindInMatrix();
		System.out.println(find.Find(target,test));
	}
}
