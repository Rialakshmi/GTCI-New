/******************
Problem Statement #

Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

Example 1:

Input: "aappp"
Output: "papap"
Explanation: In "papap", none of the repeating characters come next to each other.

Example 2:

Input: "Programming"
Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
Explanation: None of the repeating characters come next to each other.

Example 3:

Input: "aapa"
Output: ""
Explanation: In all arrangements of "aapa", atleast two 'a' will come together e.g., "apaa", "paaa".
******************/
import java.util.*;

class RearrangeString {

  public static String rearrangeString(String str) {
      HashMap<Character,Integer> hm=new HashMap<>();
    for(char c:str.toCharArray())
    hm.put(c,hm.getOrDefault(c,0)+1);
    PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
    for(Map.Entry<Character,Integer> e:hm.entrySet()) 
    pq.offer(e);
    StringBuffer sb=new StringBuffer();
    Map.Entry<Character,Integer> prev=null;
    while(!pq.isEmpty()) {
      Map.Entry<Character,Integer> curr=pq.poll();
      if(prev!=null&&prev.getValue()>1) {
        prev.setValue(prev.getValue()-1);
        pq.offer(prev); 
      }
      sb.append(curr.getKey());
     

      prev=curr;
    }
    return sb.length()==str.length()?sb.toString():"";
  }

  public static void main(String[] args) {
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
  }
}
