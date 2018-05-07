package SwardToOffer;

import java.util.ArrayList;

/**
 * Created by dell on 2018/1/22.
 */
public class printMatrix {
	//最优解应该是旋转魔方，我这个写的没什么技术含量
	//26ms 8.8K AC
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list=new ArrayList<>();
		if(matrix==null) return list;
		//行、列最大值
		int rowThreshold=matrix.length-1;
		int colThreshold=matrix[0].length-1;
		//当前行号和列号
		//行、列应该的起始位置
		int rowStart=0,colStart=0;
		int currentRow=0;
		int currentCol=0;
		//标志量 true为从上到下，从左到右
		boolean flag=true;
		while (list.size()!=matrix.length*matrix[0].length){
			//按行序为主序遍历
			//从左向右 按列遍历
			if(flag){
				currentCol=colStart;
				for(;currentCol<=colThreshold;currentCol++){
					list.add(matrix[currentRow][currentCol]);
				}
				//遍历完一行后 自然要增减行号和行限制
				currentRow++;
				rowStart++;
				//矫正 这时候会越界的
				currentCol--;
			}else {
				//从右向左
				currentCol--;
				for (;currentCol>=colStart;currentCol--){
					list.add(matrix[currentRow][currentCol]);
				}
				currentRow--;
				//矫正
				currentCol++;
				rowThreshold--;
			}

			//从上到下
			if(flag){
				for(;currentRow<=rowThreshold;currentRow++){
					list.add(matrix[currentRow][currentCol]);
				}
				//矫正
				currentRow--;
				flag=false;
				colThreshold--;
			}else {
				//从下到上
				for(;currentRow>=rowStart;currentRow--){
					list.add(matrix[currentRow][currentCol]);
				}
				colStart++;
				//矫正
				currentRow++;
				flag=true;
			}

		}
		return list;
	}

	public static void main(String[] args) {
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		printMatrix matrix1=new printMatrix();
		matrix1.printMatrix(matrix);
		for(Integer i:matrix1.printMatrix(matrix))
			System.out.println(i);
//		1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	}
}
