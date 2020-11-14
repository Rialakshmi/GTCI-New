/************
Frequency Stack (hard) #

Design a class that simulates a Stack data structure, implementing the following two operations:

    push(int num): Pushes the number ‘num’ on the stack.
    pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.

Example:

After following push operations: push(1), push(2), push(3), push(2), push(1), push(2), push(5)

1. pop() should return 2, as it is the most frequent number
2. Next pop() should return 1
3. Next pop() should return 2
************/
import java.util.*;

class FrequencyStack {
   class Node {
       int element;
       int occurence;
       int time;
       Node(int element,int occurence,int time) {
           this.element=element;
           this.occurence=occurence;
           this.time=time;
       }
    }
    PriorityQueue<Node> pq;
    HashMap<Integer,Integer> hm;
    int time;
    public FrequencyStack() {
        pq=new PriorityQueue<>((a,b)->(a.occurence==b.occurence?b.time-a.time:b.occurence-a.occurence));
        hm=new HashMap<>();
        time=0;
    }
  public void push(int x) {
        time++;
        hm.put(x,hm.getOrDefault(x,0)+1);
        pq.offer(new Node(x,hm.get(x),time));
  }

  public int pop() {
        int element=pq.poll().element;
        if(hm.get(element)>1) {
            hm.put(element,hm.get(element)-1);
        }else
            hm.remove(element);
        
        return element;
  }

  public static void main(String[] args) {
    FrequencyStack frequencyStack = new FrequencyStack();
    frequencyStack.push(1);
    frequencyStack.push(2);
    frequencyStack.push(3);
    frequencyStack.push(2);
    frequencyStack.push(1);
    frequencyStack.push(2);
    frequencyStack.push(5);
    System.out.println(frequencyStack.pop());
    System.out.println(frequencyStack.pop());
    System.out.println(frequencyStack.pop());
  }
}
