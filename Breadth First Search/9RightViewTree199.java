import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class RightViewTree {
  public static List<TreeNode> traverse(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    if(root==null)
    return result;

    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    
    while(!queue.isEmpty()) {
      int size=queue.size();
      while(size>0) {
        TreeNode curr=queue.poll();
        if(size==1) {
          result.add(curr);
        }
        if(curr.left!=null)
        queue.offer(curr.left);
        if(curr.right!=null)
        queue.offer(curr.right);
        size--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(3);
    List<TreeNode> result = RightViewTree.traverse(root);
    for (TreeNode node : result) {
      System.out.print(node.val + " ");
    }
  }
}

