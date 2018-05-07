package SwardToOffer;

/**
 * Created by dell on 2018/1/4.
 */
public class isNumeric {
	/**
	 *
	 * @param str
	 * @return
	 * 正统解法应该是有限自动状态机，模拟状态机的运行
	 * 还有就是取巧解法，使用正则匹配
	 */
	public boolean isNumeric(char[] str,int k){
		String string=String.valueOf(str);
		return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
	}
	//18ms 8.7K AC
	//暴力穷举每种匹配的模式
	public boolean isNumeric(char[] str) {
		if(str.length==0)
			return false;

		boolean onlyPoint=true;
		outer:
		for(int index=0;index<str.length;index++){
			//判断当前位是不是数字
			char ch=str[index];
			if(!Character.isDigit(ch)&&(ch!='+'&&ch!='-'&&ch!='.'&&ch!='e'&&ch!='E'))
				break ;
			if(!Character.isDigit(ch)){
				//第一位不是数字 也不是正负号
				if((index==0||str[index-1]=='e'||str[index-1]=='E')&&ch=='-') ;
				else if(ch=='-')
					break ;
				if((index==0||str[index-1]=='e'||str[index-1]=='E')&&ch=='+') ;
				else if(ch=='+')
					break ;
				//1.5e10 1.2
				else if (ch=='.')
				{

					//如果前一位不是数字,或出现两次 那么非法

						if(!onlyPoint)
						break outer;
						else if(str[index-1]=='+'||str[index-1]=='-') continue ;
					onlyPoint=false;
				}
				//e的前后都要有数字
				else if(ch=='e'||ch=='E')
					if(Character.isDigit(str[index-1])){
					for(int i=index+1;i<str.length;i++){
						if(str[i]=='.')
							break outer;
					}
					}
					else break ;

			}
			//到达末尾
			if(index==str.length-1){
				if(Character.isDigit(str[index]))
					return  true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s="-.123";
		char[] chars=s.toCharArray();
		isNumeric numeric=new isNumeric();
		System.out.println(chars.toString());

	}
}
