/***********
Problem Statement #

Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.
**************/

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(size>0) {
                TreeNode curr=queue.poll();
                temp.add(curr.val);
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
                size--;
            }
            list.add(temp);
        }
        
        return list;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}
