import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
     List<List<Integer>> list=new ArrayList<>();
        if(root!=null)
        pathSum(root,sum,0,list,new ArrayList<Integer>());
        return list;
    }
    
    public static void pathSum(TreeNode node,int sum,int currSum,List<List<Integer>> list,List<Integer> curr) {
            currSum+=node.val;
            curr.add(node.val);
            if(node.left==null&&node.right==null&&currSum==sum) {
            
                list.add(new ArrayList<Integer>(curr));
            } else {
               
                if(node.left!=null)
                pathSum(node.left,sum,currSum,list,curr);
                if(node.right!=null)
                pathSum(node.right,sum,currSum,list,curr);
            }
            
            curr.remove(curr.size()-1);
    }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}
