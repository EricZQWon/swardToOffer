package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/27.
 */
public class ReverseEqual{
		public boolean checkReverseEqual(String s1, String s2) {
			StringBuilder sb=new StringBuilder(s1+s1);

			int count=0;
			for(int index=0;index<sb.length();index++){
				//在sb字符串上滑动
				if(count!=s2.length()){
					if(sb.charAt(index)==s2.charAt(count))
						count++;
					else
						count=0;
				}else {
					return true;
				}
			}
			if(count!=s2.length())
			return false;
			else
				return true;
		}

	public static void main(String[] args) {
		ReverseEqual equal=new ReverseEqual();
		System.out.println(equal.checkReverseEqual("Hello world","worldhello "));
	}
}
