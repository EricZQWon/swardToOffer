package Cracking_Coding_Interview;

import java.util.Arrays;

public class Render {
	public int[] renderPixel(int[] screen, int x, int y) {
		// write code here
		//数组中每个元素代表一个8bit的数
		int indexStart=0;
		int indexEnd=7;
		for (int i=0;i<screen.length;i++,indexStart+=8,indexEnd+=8){
			//在区间之内
			/**
			 * 		分3种情况：
			 * 		x,y都在里面，
			 * 		x在里面，y在外面
			 * 		x在外面，y在里面
			 */
			int start=0,end=0;
			if(x>=indexStart&&y<=indexEnd){
				start=x;
				end=y;
			}else if ((x>=indexStart&&x<=indexEnd)&&y>=indexEnd){
				start=x;
				end=indexEnd;
			}else if ((indexStart<=y&&indexEnd>=y)&&x<=indexStart){
				start=indexStart;
				end=y;
			}else {

			}
			start=8-(start%8);
			end=(end+1)%8;
			screen[i]=(int)(Math.pow(2,start)-Math.pow(2,end));
		}
		return screen;
	}

	public static void main(String[] args) {
		int[] screen={0,0,0,0,0,0};
		Render render=new Render();
		int[] res=render.renderPixel(screen,7,8);
		Arrays.stream(res).forEach(System.out::println);
	}
}
