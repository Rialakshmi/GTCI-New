/*****
Problem Statement #

Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.

Example 1:

Input: [1, 3, 5, 12, 11, 12, 11], K = 2
Output: [12, 11]
Explanation: Both '11' and '12' apeared twice.

Example 2:

Input: [5, 12, 11, 3, 11], K = 2
Output: [11, 5] or [11, 12] or [11, 3]
Explanation: Only '11' appeared twice, all other numbers appeared once.
*****/
import java.util.*;

class TopKFrequentNumbers {

  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topNumbers = new ArrayList<>(k);
    HashMap<Integer,Integer> hm=new HashMap<>();
    for(int num:nums) {
      hm.put(num,hm.getOrDefault(num,0)+1);
    }

    PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
    for(Map.Entry<Integer,Integer> e:hm.entrySet()) {
      pq.offer(e);
      if(pq.size()>k)
      pq.poll();
    }


    while(!pq.isEmpty())
    topNumbers.add(pq.poll().getKey());

    return topNumbers;
  }

  public static void main(String[] args) {
    List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}
