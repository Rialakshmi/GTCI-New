/*************************
Problem Statement #

Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

************************/
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] arr) {
    return helper(root,arr,0);
  }
   public static boolean helper(TreeNode node,int[] arr,int index) {
        if(node==null)
            return false;
        if(index<arr.length&&node.val!=arr[index])
            return false;
        if(node.left==null&&node.right==null) {
            if(index==arr.length-1) {
                if(arr[index]==node.val)
                    return true;
                else
                    return false;
            } 
        }
        if(node.left!=null && node.right!=null)
        return helper(node.left,arr,index+1) || helper(node.right,arr,index+1);
        else if(node.left!=null)
            return helper(node.left,arr,index+1);
        else
            return helper(node.right,arr,index+1);
    }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
