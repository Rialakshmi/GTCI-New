/**********
Problem Statement #

Given a string, sort it based on the decreasing frequency of its characters.

Example 1:

Input: "Programming"
Output: "rrggmmPiano"
Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.

Example 2:

Input: "abcbab"
Output: "bbbaac"
Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.
**********/
import java.util.*;

class FrequencySort {

  public static String sortCharacterByFrequency(String str) {
   
    HashMap<Character,Integer> hm=new HashMap<>();
    for(char c:str.toCharArray()) 
      hm.put(c,hm.getOrDefault(c,0)+1);
    PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
    for(Map.Entry<Character,Integer> e:hm.entrySet()) 
    pq.offer(e);
    StringBuffer sb=new StringBuffer();
    while(!pq.isEmpty()) {
      Map.Entry<Character,Integer> e=pq.poll();
      Integer num=e.getValue();
      char c=e.getKey();
      for(int i=1;i<=num;i++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
  }
}
