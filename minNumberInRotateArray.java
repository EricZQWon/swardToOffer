package SwardToOffer;

/**
 * Created by dell on 2017/12/22.
 */
public class minNumberInRotateArray {
    //最弱智的暴力破解，直接调用Arrays.sort 几乎通过不了 接近上限
    int min=0;
    //直接调用antherOne里面的迭代版本 287ms
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)
            return 0;
        int low=0;int high=array.length-1;
        int mid=-1;
        outer:
        while(mid!=low||mid!=high){
            mid=(low+high)/2;
            if(array[mid-1]>array[mid]){
                min=array[mid];
                break outer;
            }
            if(array[mid]==array[high])
                high-=1;
            else if(array[mid]>array[high])
                low=mid;
            else if(array[low]>array[mid])
                high=mid-1;
        }
        return min;

    }
    //递归版本 性能较差 345ms....不知道为啥这么高
    public int search(int lo,int high,int[] array){
        int mid=(lo+high)/2;
        if(array[mid-1]>array[mid])
           min=array[mid];
        if(array[mid+1]<array[mid])
            min=array[mid+1];
        else if(array[mid]>array[high])
            search(mid+1,high,array);
        else if(array[lo]>array[mid])
            search(lo,mid-1,array);
       return min;
    }
    //性能稍优 301ms，占用内存接近规定的上线了。。。。
    public int anotherOne(int lo,int high,int[] array){
        int mid=-1;

        while(mid!=lo||mid!=high){
            mid=(lo+high)/2;
            if(array[mid-1]>array[mid]){
                min=array[mid];

            }

            if(array[mid+1]<array[mid]) {
                min = array[mid + 1];

            }
            else if(array[mid]>array[high])
                lo=mid+1;
            else if(array[lo]>array[mid])
                high=mid-1;
        }
        return min;
    }
    public static void main(String[] args) {
     minNumberInRotateArray min=new minNumberInRotateArray();
     int[] array={1,0,1,1,1,1};
        System.out.println(min.minNumberInRotateArray(array));
    }
}
