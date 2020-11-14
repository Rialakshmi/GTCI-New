/****************
Problem Statement #
Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.
Example 1:
Input: [7, 3, 5, 8, 5, 3, 3], and K=2
Output: 3
Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have 
to skip 5 because it is not distinct and occurred twice. 
Another solution could be to remove one instance of '5' and '3' each to be left with three 
distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.
Example 2:
Input: [3, 5, 12, 11, 12], and K=3
Output: 2
Explanation: We can remove one occurrence of 12, after which all numbers will become distinct. Then 
we can delete any two numbers which will leave us 2 distinct numbers in the result.
Example 3:
Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
Output: 3
Explanation: We can remove one occurrence of '4' to get three distinct numbers.
***************/
import java.util.*;

class MaximumDistinctElements {

  public static int findMaximumDistinctElements(int[] nums, int k) {
    HashMap<Integer,Integer> hm=new HashMap<>();
    for(int num:nums)
    hm.put(num,hm.getOrDefault(num,0)+1);
    PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
    int numDistincts=0;
    for(Map.Entry<Integer,Integer> e:hm.entrySet()) {
      if(e.getValue()==1)
      numDistincts++;
      else
      pq.offer(e);
    }

    while(!pq.isEmpty()&&k>0) {
      Map.Entry<Integer,Integer> e=pq.poll();
      
        k-=e.getValue()-1;
      

      if(k>=0)
      numDistincts++;
    }
    if(k>0)
    numDistincts-=k;
    return numDistincts;
  }

  public static void main(String[] args) {
    int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);
  }
}
