package SwardToOffer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dell on 2018/1/16.
 */
public class hasPath {
	//15ms 13K AC
	//核心思想 回溯法
	//利用一个栈，这里写成队列了，一样的其实 记录每个可能的起点。
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{
		char[][] Mat=new char[rows][cols];
		ArrayList<Point> list=new ArrayList<>();
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				//构建一个二维数组
				Mat[i][j]=matrix[i*cols+j];
				//如果等于入口元素 进队列
				if(Mat[i][j]==str[0])
				list.add(new Point(i,j));
			}
		}
		if(list.size()==matrix.length&&str.length<=matrix.length)
			return true;

		while (!list.isEmpty()){
			//新建辅助数组 避免影响原数组
			char[][] temp=new char[rows][cols];
			for(int i=0;i<rows;i++) {
				for (int j = 0; j < cols; j++) {
					temp[i][j]=Mat[i][j];
				}
			}
			//记录已经访问到字符串的哪个位置
			int index=1;

			outer:
			for(;index<str.length;index++){
				Point start=list.remove(list.size()-1);
				int x=start.x; int y=start.y;
				temp[x][y]='0';
				char up='0';
				char under='0';
				char left='0';
				char right='0';
				if(x!=0)
					up=temp[x-1][y];
				if(x!=rows-1)
					under=temp[x+1][y];
				if(y!=0)
					left=temp[x][y-1];
				if(y!=cols-1)
					right=temp[x][y+1];

				//特殊情况都排除了，这时候就是在腹地，可以上下左右随便动
				if(str[index]==up){
					temp[x-1][y]='0';
					list.add(new Point(x-1,y));
				}if (str[index]==under){
					temp[x+1][y]='0';
					list.add(new Point(x+1,y));
				}if(str[index]==left) {
					temp[x][y-1]= '0';
					list.add(new Point(x,y-1));
				}
				if(str[index]==right) {
					temp[x][y+1] = '0';
					list.add(new Point(x,y+1));
				}
				if(str[index]!=up&&str[index]!=under&&str[index]!=left&&str[index]!=right)
					break outer;

			}
			if(index==str.length) return true;
		}
		return false;
	}

	public static void main(String[] args) {

		String str="AAAAAAAAAAAA";

		int rows=3; int cols=4;
		hasPath path=new hasPath();
		String s="AAAAAAAAAAAA";
		System.out.println(path.hasPath(str.toCharArray(),rows,cols,s.toCharArray()));
	}
}
