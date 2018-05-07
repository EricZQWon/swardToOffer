package SwardToOffer;

/**
 * Created by dell on 2017/12/21.
 */
public class AddWithout {
    public int Add(int num1,int num2) {
        int temp;
        while (num2!=0){
            //^异或运算相当于不进位加法
            temp=num1^num2;
            //&+<<1 相当于一次进位运算
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }
    public  static  void main(String[] args){
        AddWithout add=new AddWithout();
        System.out.println(add.Add(12,8));
    }
}
