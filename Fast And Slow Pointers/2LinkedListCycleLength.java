/**
Similar Problems #

Problem 1: Given the head of a LinkedList with a cycle, find the length of the cycle.

Solution: We can use the above solution to find the cycle in the LinkedList. Once the fast and slow pointers meet, we can save the slow pointer and iterate the whole cycle with another pointer until we see the slow pointer again to find the length of the cycle.
**/
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleLength {

  public static int findCycleLength(ListNode head) {
    ListNode cycleHead=detectCycle(head);
    if(cycleHead!=null) {
      ListNode curr=cycleHead.next;
      int l=1;
      while(curr!=cycleHead) {
        curr=curr.next;
        l++;
      }
      return l;
    } else
      return 0;
  }
  public static ListNode detectCycle(ListNode head) {
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
  private static int calculateLength(ListNode slow) {
    ListNode current = slow;
    int cycleLength = 0;
    do {
      current = current.next;
      cycleLength++;
    } while (current != slow);
    return cycleLength;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
  }
}
