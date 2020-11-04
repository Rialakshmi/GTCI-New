/****
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL


****/
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseSubList {

  public static ListNode reverse(ListNode head, int m, int n) {
      if(m==n || head == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        
        for(int i=1;i<m&&curr!=null;i++) {
            prev = curr;
            curr = curr.next;
        }
        
        ListNode lastNodeFirstSubArray = prev;
        ListNode lastNodeSecondSubArray = curr;
         ListNode temp =null;
        for(int i=1;i<=n-m+1&&curr!=null;i++) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        if(lastNodeFirstSubArray!=null)
            lastNodeFirstSubArray.next = prev;
        else 
            head=prev;
        
        lastNodeSecondSubArray.next = curr;
        
        return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode result = ReverseSubList.reverse(head, 2, 4);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
