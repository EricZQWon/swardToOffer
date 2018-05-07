package SwardToOffer;

/**
 * Created by dell on 2017/12/20.
 */
public class Power {
    public double bestOne(double base,int exponent){
        double count=1.0;
        //按位与&
       int x=1;    int abs=0;
       if(exponent>=0) abs=exponent;
       else  abs=-exponent;
        if(exponent!=0){
            while (x<=abs){
              if((abs&x)!=0)
                  count*=base;
              base*=base;
                x<<=1;
            }
            return  exponent>=0?count:1/count;
        }

        return count;
    }
    public double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }
    public double anotherOne(double base,int exponent){
        double count=1.0;
        int abs=Math.abs(exponent);
        if(exponent!=0){
            for(int i=0;i<abs;i++){
                count*=base;
            }
        }
        else
        return count;
        return  exponent>0?count:1/count;
    }
    public static void main(String[] args){
        Power power=new Power();
            System.out.println(power.bestOne(2.0,-2));

    }
}
interface B{
    static  void m(){

    }
}
