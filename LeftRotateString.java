package SwardToOffer;

/**
 * Created by dell on 2017/12/25.
 */
public class LeftRotateString {
	//虽然看起来是最佳的答案 但是AC的效率并不好 可能是因为Java String不可变的原因
	//C++好像表现不错
	//思路很好 学习一下
	//21ms 9.1K AC
	public String BestOne(String str,int n){
		if(str.length()==0)
			return "";
		n%=str.length();

		//核心操作 将两个str拼接出来，取中间部分就好
		String string=str+str;
		return string.substring(n,str.length()+n);
	}
	//19ms 13K AC
	public String LeftRotateString(String str,int n) {
		if(str.length()==0)
			return "";
		String s=str.substring(0,n);
		String a=str.substring(n);
		return a+s;
	}
	//18ms 8.9K AC
	public String anotherOne(String str,int n){
		if(str.length()==0)
			return "";
		StringBuilder string=new StringBuilder(str.substring(n));
		for(int index=0;index<n;index++)
			string.append(str.charAt(index));
		return string.toString();
	}

	public static void main(String[] args) {
		LeftRotateString left=new LeftRotateString();
//		System.out.println(left.LeftRotateString(null,3));
		System.out.println(left.BestOne("abxYZ",3));
	}
}
