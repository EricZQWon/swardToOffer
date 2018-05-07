package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/29.
 */
public class BinDecimal {
	public String printBin(double num) {
		StringBuilder sb=new StringBuilder("0.");
		double temp=0.5,result=0.0;
		while (sb.length()<=33){
			if((temp+result)>num){
				sb.append(0);
			}else {
				result+=temp;
				sb.append(1);
				if (result==num)
					return sb.toString();
			}
			temp/=2;
		}
		return "ERROR";
	}

	public static void main(String[] args) {
		double a=0.625;
		BinDecimal decimal=new BinDecimal();
		System.out.println(decimal.printBin(a));

	}
}
