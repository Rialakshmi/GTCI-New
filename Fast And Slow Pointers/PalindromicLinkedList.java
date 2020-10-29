/***
Palindrome LinkedList (medium) #

Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have O(N)O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

Example 1:

Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true

Example 2:

Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
Output: false
****/
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class PalindromicLinkedList {

  public static boolean isPalindrome(ListNode head) {
     ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return false;
        }
        
        ListNode secondHalf=reverse(slow);
        ListNode copyOfSecondHalf=secondHalf;
        
        while(head!=null&&secondHalf!=null) {
            if(head.val!=secondHalf.val)
                break;
            head=head.next;
            secondHalf=secondHalf.next;
        }
        reverse(copyOfSecondHalf);
        if(head==null||secondHalf==null) {
            return true;
        } else
            return false;
    }
    
    public static ListNode reverse(ListNode node) {
        ListNode prev=null;
        while(node!=null) {
            ListNode temp=node.next;
            node.next=prev;
            prev=node;
            node=temp;
        }
        
        return prev;
    }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }
}
