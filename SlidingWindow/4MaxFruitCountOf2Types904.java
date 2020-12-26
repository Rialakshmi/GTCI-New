/**
Problem Statement #

Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Example 2:

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
**/

import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    int j=0;
    int max=0;
    HashMap<Character,Integer> hm=new HashMap<>();
    for(int i=0;i<arr.length;i++) {
      hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
      while(hm.size()>2) {
        if(hm.get(arr[j])==1)
        hm.remove(arr[j]);
        else
        hm.put(arr[j],hm.get(arr[j])-1);
        j++;
      }
      if(hm.size()==2)
      max=Math.max(max,i-j+1);
    }
    return max;
  }
}
