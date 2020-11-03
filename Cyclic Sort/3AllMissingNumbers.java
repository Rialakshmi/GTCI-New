/****
Problem Statement #

We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.

Example 2:

Input: [2, 4, 1, 2]
Output: 3

Example 3:

Input: [2, 3, 2, 1]
Output: 4
*****/
import java.util.*;

class AllMissingNumbers {

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();
    for(int i=0;i<nums.length;i++) {
      while(nums[i]!=i+1&&nums[i]!=nums[nums[i]-1]) {
        swap(nums,i,nums[i]-1);
      }
    }
    for(int i=0;i<nums.length;i++) {
      if(nums[i]!=i+1)
      missingNumbers.add(i+1);
    }
    return missingNumbers;
  }

  public static void swap(int[] nums,int i1,int i2) {
    int temp=nums[i1];
    nums[i1]=nums[i2];
    nums[i2]=temp;
  }
}
