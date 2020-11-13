/****
Problem Statement #

Given an unsorted array of numbers, find the ‘K’ largest numbers in it.

Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.

Example 1:

Input: [3, 1, 5, 12, 2, 11], K = 3
Output: [5, 12, 11]

Example 2:

Input: [5, 12, 11, -1, 12], K = 3
Output: [12, 11, 12]
****/
import java.util.*;

class KLargestNumbers {

  public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    List<Integer> list=new ArrayList<>();
    for(int num:nums) {
      pq.offer(num);
      if(pq.size()>k)
      pq.poll();
    }

    while(!pq.isEmpty()) {
      list.add(pq.poll());
    }
    return list;
  }

  public static void main(String[] args) {
    List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
    System.out.println("Here are the top K numbers: " + result);

    result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Here are the top K numbers: " + result);
  }
}
