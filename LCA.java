package Cracking_Coding_Interview;

/**
 * Created by dell on 2018/1/26.
 */
public class LCA {
	int common;
	public int getLCA(int a, int b) {
		//如果a==b,证明到头了
		if(a==b){
			common=a;
		}else {
			if(a>b){
				getLCA(a/2,b);
			}else {
				getLCA(a,b/2);
			}
		}
		return  common;
	}

	public static void main(String[] args) {
		LCA lca=new LCA();
		System.out.println(lca.getLCA(12,7));
	}
}
