
/*****
Problem Statement #

Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.

******/
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class TreePathSum {
  public static boolean hasPath(TreeNode root, int sum) {
    // TODO: Write your code here
    return hasPath(root,sum,0);
  }

  public static boolean hasPath(TreeNode node,int sum,int currSum) {
     if(node==null)
           return false;
        else {
            currSum+=node.val;
            if(node.left==null&&node.right==null&&currSum==sum)
                return true;
            else
                return hasPath(node.left,sum,currSum) || hasPath(node.right,sum,currSum);
        }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
  }
}
