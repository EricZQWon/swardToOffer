package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/29.
 */
public class ReverseString {
	public String reverseString(String iniString) {
		StringBuilder sb=new StringBuilder(iniString);
		return sb.reverse().toString();
	}

}
