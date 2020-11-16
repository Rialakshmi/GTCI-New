/********************************
Problem Statement #

Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.

********************************/
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    return pathSum(root,0);
  }

   public static int pathSum(TreeNode node,int pathSum) {
        if(node==null)
            return 0;
        pathSum=pathSum*10+node.val;
        
        if(node.left==null&&node.right==null)
            return pathSum;
        return pathSum(node.left,pathSum) + pathSum(node.right,pathSum);
    }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}
