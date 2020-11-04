/***
Reverse alternating K-element Sub-list (medium) #

Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

****/
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k) {
    ListNode prev=null;
    ListNode curr=head;
    boolean reverse=true;
    while(true) {
      ListNode lastNodePrevList=prev;
      ListNode lastNodeCurrList=curr;
      if(!countNodes(curr,k))
      break;
      else {
        for(int i=1;i<=k&&curr!=null;i++) {
          ListNode temp=curr.next;
          curr.next=prev;
          prev=curr;
          curr=temp;
        }
        if(lastNodePrevList==null)
          head=prev;
        else
          lastNodePrevList.next=prev;
        lastNodeCurrList.next=curr;  
        for(int i=1;i<=k&&curr!=null;i++) {
          prev=curr;
          curr=curr.next;
        }

        if(curr==null)
        break;
        
      }
    }
    return head;
  }

  public static boolean countNodes(ListNode node,int k) {
    int i=0;

    while(i<k&&node!=null) {
      node=node.next;
      i++;
    }

    return i==k;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 2);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
