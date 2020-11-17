/********************
Path with Maximum Sum (hard) #

Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.

A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root. The path must contain at least one node.

********************/
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class MaximumPathSum {
 static int max=Integer.MIN_VALUE;
  public static int findMaximumPathSum(TreeNode root) {
    helper(root);
    return max;
  }

    public static int helper(TreeNode node) {
        if(node==null)
            return 0;
        
        int left=0,right=0;
        if(node.left!=null)
            left= Math.max(0,helper(node.left));
        if(node.right!=null)
            right=Math.max(0,helper(node.right));
        
        max= Math.max(max, node.val+left+right);
        
        return Math.max(left,right) + node.val;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root = new TreeNode(-1);
    root.left = new TreeNode(-3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
  }
}
