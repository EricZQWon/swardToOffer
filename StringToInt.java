package SwardToOffer;

/**
 * Created by dell on 2018/1/4.
 */
//要求不能使用String转换的库函数
public class StringToInt {
	//13ms 8.6K AC
	public int StrToInt(String str) {
		if(str.length()==0)
			return 0;
		//正负号
		boolean isPositive=true;
		//是否含有正负号
		boolean flag=false;
		//.的位置
		int _pointIndex=0;
		//e的位置
		int _eIndex=str.length()-1;
		outer:
		for(int index=0;index<str.length();index++){
			//判断当前位是不是数字
			char ch=str.charAt(index);
			if(!Character.isDigit(ch)&&(ch!='+'&&ch!='-'&&ch!='.'&&ch!='e'))
				break ;
			if(!Character.isDigit(ch)){
				//第一位不是数字 也不是正负号
				if(index==0&&ch=='-') {
					isPositive = false;
					flag=true;
				}
				if(index==0&&ch=='+') {
					isPositive = true;
					flag=true;
				}
				//1.5e10 1.2
				else if (ch=='.')
				{
					//如果前一位不是数字 那么非法
					if(!Character.isDigit(str.charAt(index-1)))
						break;
					_pointIndex=index;
				}
				//e的前后都要有数字
				else if(ch=='e')
					if(Character.isDigit(str.charAt(index-1))&&Character.isDigit(str.charAt(index+1))){
						_eIndex=index;
					}
						else break ;

			}
			//到达末尾
			if(index==str.length()-1){
				double result=0.0;
				int big=0;
				double small=0.0;
				int ten=0;
				//计算整数部分
				//如果没有小数点
				if(_pointIndex==0)
					_pointIndex=_eIndex;
				//含有正负号 第一位不是数字
				if(flag==true)
					for(int i=_pointIndex,n=1;i>0;i--,n*=10){
						big+=(str.charAt(i)-48)*n;
					}
				else
				for(int i=_pointIndex,n=1;i>=0;i--,n*=10){
					big+=(str.charAt(i)-48)*n;
				}
				if(big==-2147483648)
					return -2147483648;
				//计算小数部分
				for(int i=_pointIndex+1,n=10;i<_eIndex;i++,n*=10){
 					small+=(double)(str.charAt(i)-48)/n;
				}
				result=big+small;
				//计算科学计数法大小
				for(int j=str.length()-1,n=1;j>_eIndex;j--,n*=10){
					ten+=(str.charAt(j)-48)*n;
				}
				ten=(int)Math.pow(10,ten);
				//负号
				if(!isPositive)
					result=result*ten*-1;
				else
					result*=ten;
				return  (int)result;
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		String s="-2147483648";
		StringToInt stringToInt=new StringToInt();
		System.out.println(stringToInt.StrToInt(s));
		int ss=-2147483648;
		System.out.println(ss);
	}
}
