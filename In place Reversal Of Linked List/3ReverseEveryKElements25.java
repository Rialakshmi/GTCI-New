/*****
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

    Could you solve the problem in O(1) extra memory space?
    You may not alter the values in the list's nodes, only nodes itself may be changed.

*****/
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
        
        while(true) {
            ListNode lastNodeSubList=prev;
            ListNode lastNodeCurrList=curr;
            
            if(!countNode(curr,k))
                break;
            else {
                for(int i=1;i<=k&&curr!=null;i++) {
                    ListNode temp=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=temp;
                }
                
                if(lastNodeSubList==null)
                    head=prev;
                else
                    lastNodeSubList.next=prev;
                lastNodeCurrList.next=curr;
                if(curr==null)
                    break;
                
                prev=lastNodeCurrList;
            }
        }
        
        return head;
  }

    public static boolean countNode(ListNode node,int num) {
        ListNode curr=node;
        int temp=num;
        while(curr!=null&&temp>0) {
            temp--;
            curr=curr.next;
        }
        
        return temp==0;
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

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
