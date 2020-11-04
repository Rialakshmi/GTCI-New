/***
Rotate a LinkedList (medium) #

Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.

****/
import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class RotateList {

  public static ListNode rotate(ListNode head, int k) {
      if(head==null || head.next==null || k<=0)
            return head;
        ListNode last=head;
        int listLength=1;
        while(last.next!=null) {
            last=last.next;
            listLength++;
        }
        k%=listLength;
        last.next=head;
        ListNode curr=head;
        int remaining=listLength-1-k;
        for(int i=1;i<=remaining&&curr!=null;i++) {
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    ListNode result = RotateList.rotate(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
