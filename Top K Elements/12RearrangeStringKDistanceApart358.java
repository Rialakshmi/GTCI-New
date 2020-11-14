/******************
Rearrange String K Distance Apart (hard) #

Given a string and a number ‘K’, find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.

Example 1:

Input: "mmpp", K=2
Output: "mpmp" or "pmpm"
Explanation: All same characters are 2 distance apart.

Example 2:

Input: "Programming", K=3
Output: "rgmPrgmiano" or "gmringmrPoa" or "gmrPagimnor" and a few more
Explanation: All same characters are 3 distance apart.

Example 3:

Input: "aab", K=2
Output: "aba"
Explanation: All same characters are 2 distance apart.

Example 4:

Input: "aappa", K=3
Output: ""
Explanation: We cannot find an arrangement of the string where any two 'a' are 3 distance apart.
******************/
import java.util.*;

class RearrangeStringKDistanceApart {

  public static String reorganizeString(String str, int k) {
     HashMap<Character,Integer> hm=new HashMap<>();
    for(char c:str.toCharArray())
    hm.put(c,hm.getOrDefault(c,0)+1);
    PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
    for(Map.Entry<Character,Integer> e:hm.entrySet()) 
    pq.offer(e);
    StringBuffer sb=new StringBuffer();
    Queue<Map.Entry<Character,Integer>> queue=new LinkedList<>();
    while(!pq.isEmpty()) {
      Map.Entry<Character,Integer> curr=pq.poll();
      sb.append(curr.getKey());
      curr.setValue(curr.getValue()-1);
      queue.offer(curr);
      if(queue.size()==k) {
        Map.Entry<Character,Integer> prev=queue.poll();
        if(prev.getValue()>0)
        pq.offer(prev); 
      }
      
      
    }
    return sb.length()==str.length()?sb.toString():"";
  }

  public static void main(String[] args) {
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
  }
}
