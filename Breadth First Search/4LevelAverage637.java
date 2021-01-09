import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root) {
       Queue<TreeNode> queue=new LinkedList<>();
       List<Double> list=new ArrayList<>();
        if(root==null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            double sum=0;
            for(int i=0;i<size;i++) {
                TreeNode curr=queue.poll();
                sum+=curr.val;
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
               
            }
            list.add(sum/size);
        }
        
        return list;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = LevelAverage.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}
