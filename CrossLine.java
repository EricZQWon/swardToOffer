package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/25.
 */
public class CrossLine {
	public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
		// write code here
		if(s1==s2&&y1!=y2) return false;
		else
			return true;
	}
}
