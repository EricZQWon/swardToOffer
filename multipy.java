package SwardToOffer;

/**
 * Created by dell on 2017/12/21.
 */
public class multipy {
    public int[] multiply(int[] A) {
        int length=A.length;
        int[] B=null;
        if(length!=0){
            B=new int[length];
            B[0]=1;
        }

        //计算下三角 自上而下连乘
        for(int i=1;i<length;i++)
        {
            B[i]=B[i-1]*A[i-1];
        }
        //实际是将B[0]的值暂存，因为上三角要自下而上连乘，SwardToOffer.B[0]的值会改变，就是1
        int temp=1;
        for(int j=length-2;j>0;j--){
            temp*=A[j+1];
            B[j]*=temp;
        }
        return B;
    }
}
