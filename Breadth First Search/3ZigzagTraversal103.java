import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
     Queue<TreeNode> queue=new LinkedList<>();
        boolean left=true;
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(size>0) {
                TreeNode curr=queue.poll();
                if(left)
                temp.add(curr.val);
                else
                    temp.add(0,curr.val);
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
                size--;
            }
            list.add(temp);
            left=left?false:true;
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
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}
