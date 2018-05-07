package SwardToOffer; /**
 * Created by dell on 2017/12/23.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class printTreeByLevlel {
    //第一次进排行榜哈哈哈  15ms通过测试
    ArrayList<ArrayList<Integer>> queue=new ArrayList<>();
    ArrayList<Integer> level=new ArrayList<>();
    Queue<TreeNode> travel=new LinkedList<>();
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot==null)
            return queue;
        //记录每一层的节点数
        int levelCount=1;
        //记录当前访问到的这一层的第几个节点
        int currentCount=0;
        //记录下一层的节点数
        int nextLevelCount=0;
       travel.add(pRoot);
       while(!travel.isEmpty())
       {
            TreeNode temp=travel.remove();
            level.add(temp.val);
            currentCount++;
           //广度优先遍历，依次将左右子节点加入队列
           if(temp.left!=null) {
               travel.add(temp.left);
               //这一层的节点数+1
               nextLevelCount++;
           }
           if(temp.right!=null) {
               travel.add(temp.right);
               nextLevelCount++;
           }
            //当前层节点已经访问完毕
            if(levelCount==currentCount){
                //这一层的节点加入队列
                queue.add(level);
                //更新为下一层的节点数
                levelCount=nextLevelCount;
                //已经统计的节点数置0
                currentCount=0;
                //下一层的节点数归零 重新计数
                nextLevelCount=0;
                //当前层统计的归零
               level=new ArrayList<>();
            }

       }
       return queue;
    }

    public static void main(String[] args) {
        printTreeByLevlel print=new printTreeByLevlel();
        TreeNode node1=new TreeNode(8);
        TreeNode node2=new TreeNode(6);
        TreeNode node3=new TreeNode(10);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(7);
        TreeNode node6=new TreeNode(9);
        TreeNode node7=new TreeNode(11);
      node1.left=node2; node1.right=node3;
      node2.left=node4; node2.right=node5;
      node3.left=node6; node3.right=node7;
      print.Print(node1);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}