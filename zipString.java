package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/27.
 */
public class zipString {
	public String zipString(String iniString) {
		StringBuilder sb=new StringBuilder();
		sb.append(iniString.charAt(0));
		int count=1;
		for(int i=1;i<iniString.length();i++){
			if(iniString.charAt(i)==iniString.charAt(i-1))
			{
				count++;
			}else {
				sb.append(count);
				sb.append(iniString.charAt(i));
				count=1;
			}
		}
		sb.append(count);
		if(sb.length()>=iniString.length())
			return iniString;
		else
			return sb.toString();
	}
	public String one(String string){
		StringBuilder sb=new StringBuilder();
		int count=1;
		sb.append(string.charAt(string.length()-1));
		for(int i=string.length()-1;i>0;i--){
			if(string.charAt(i)==string.charAt(i-1))
				count++;
			else {
				sb.insert(0,count);
				sb.insert(0,string.charAt(i));
				count=1;
			}
		}
		sb.insert(0,count);
		return sb.toString();
	}

	public static void main(String[] args) {
		String string="AAAABCCDAA";
		zipString zipString=new zipString();
		System.out.println(zipString.one(string));
	}
}
