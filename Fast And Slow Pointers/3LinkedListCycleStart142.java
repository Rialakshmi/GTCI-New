/**
Problem Statement #

Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.

**/
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
     ListNode hare=head;
        ListNode tortoise=head;
        ListNode intersect=null;
        while(hare!=null&&hare.next!=null) {
            tortoise=tortoise.next;
            hare=hare.next.next;
            if(hare==tortoise) {
                intersect=hare;
                break;
            }
        }
        
        if(head==null || intersect==null)
            return null;
        
        while(head!=intersect) {
            head=head.next;
            intersect=intersect.next;
        }
        
        return intersect;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}
