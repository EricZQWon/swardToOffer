package SwardToOffer;



/**
 * Created by dell on 2018/1/12.
 */
public class VerifySquenceOfBST {
	boolean flag=true;
	public boolean VerifySquenceOfBST(int [] sequence) {
		for(int j=sequence.length-1;j>=0;j--){
			//当前根节点
			int rootCase=sequence[j];
			int leftIndex=-1;
			for(int i=0;i<j;i++){
				if(sequence[i]<rootCase)
					leftIndex++;
			}
			int rightIndex=leftIndex+1;
			flag=check(sequence,leftIndex,rightIndex,j-1,rootCase);
			if(flag==false)
				return false;
		}
		return true;

	}
	public boolean check(int[] seq,int leftEnd,int rightStart,int end,int rootValue){
		if(leftEnd!=-1){
			for(int i=0;i<=leftEnd;i++){
				if(seq[i]>rootValue)
					return false;
			}
		}
		for(int j=rightStart;j<=end;j++){
			if(seq[j]<rootValue)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] seq={5,7,6,9,11,10,8};
		VerifySquenceOfBST verify=new VerifySquenceOfBST();
		System.out.println(verify.VerifySquenceOfBST(seq));
	}
}
//遍历后序数组
//		//在X之前 需要满足：1、是X的孩子
////							2、是X的左兄弟节点
//		for(int i=sequence.length-2;i>0;i--){
//			int before=sequence[i-1];
//			//如果前一个大于当前X 那么它不可能是X的左兄弟节点 只可能是X的右孩子
//			if(before>sequence[i]){
//				//在中序序列中找到X的右孩子
//				inner:
//				for(int j=0;j<inOrder.length;j++){
//					if(inOrder[j]==sequence[i])
//						if(inOrder[j+1]!=before)
//							return false;
//						else
//							break inner;
//				}
//			}
//
//		}