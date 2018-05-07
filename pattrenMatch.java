package SwardToOffer;

/**
 * Created by dell on 2018/1/24.
 */
public class pattrenMatch {
	public boolean match(char[] str, char[] pattern)
	{
		if(str.length==0&&pattern.length==0) return true;
		if(str.length!=0&&pattern.length==0) return false;
		//str当前字符索引
		int currentIndex=0;
		int index=0;
		for(;index<pattern.length;index++){
			//'.'表示匹配任意单个字符
			if(pattern[index]=='.') {
				currentIndex++;
				//".*"匹配一切
				if(index+1<pattern.length&&pattern[index+1]=='*') return true;
			}
			else if(pattern[index]=='*'){
				continue;
			}else {
				if(index!=pattern.length-1){
					if(pattern[index+1]=='*'){
						char temp=pattern[index];
						while (currentIndex<str.length&&temp==str[currentIndex]){
							currentIndex++;
						}
					}
					else if(str[currentIndex]!=pattern[index])
						return false;
					else {
						currentIndex++;
					}
					//是模式的最后一个字符，且不为通配符
				}else {
						if(currentIndex>=str.length&&index<pattern.length) return false;
						if(str[currentIndex]!=pattern[index])
							return false;
						else {
							currentIndex++;
						}
				}
			}
		}
		if(currentIndex!=str.length) return false;
		return true;
	}
//"",".*"
	public static void main(String[] args) {
		String s="aaa";
		String pattern="a*a";
//		String pattern="ab*ac*a";
		pattrenMatch pattrenMatch=new pattrenMatch();
		System.out.println(pattrenMatch.match(s.toCharArray(),pattern.toCharArray()));
	}
}
