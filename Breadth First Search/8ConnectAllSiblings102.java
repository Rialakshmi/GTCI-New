import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }
};

class ConnectAllSiblings {
  public static void connect(TreeNode root) {
    
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode prev=null;
        while(!queue.isEmpty()) {
            
            int size=queue.size();
            Queue<TreeNode> levelList=new LinkedList<>();
           
            while(size>0) {
                TreeNode curr=queue.poll();
                if(prev!=null)
                    prev.next=curr;
                prev=curr;
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
                size--;
            }

        }
        prev.next=null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}
