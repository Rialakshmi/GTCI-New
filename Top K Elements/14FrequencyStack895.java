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
