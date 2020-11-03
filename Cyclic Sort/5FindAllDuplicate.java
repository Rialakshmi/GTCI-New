/***
Problem Statement #

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.

Example 1:

Input: [3, 4, 4, 5, 5]
Output: [4, 5]

Example 2:

Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]
****/
import java.util.*;

class FindAllDuplicate {

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> duplicateNumbers = new ArrayList<>();
    for(int i=0;i<nums.length;i++) {
      while(nums[i]!=i+1) {
        if(nums[nums[i]-1]==nums[i]) {
          duplicateNumbers.add(nums[i]);
          break;
        }
        swap(nums,i,nums[i]-1);
      }
    }
    return duplicateNumbers;
  }

  public static void swap(int[] nums,int i1,int i2) {
    int temp=nums[i1];
    nums[i1]=nums[i2];
    nums[i2]=temp;
  }
}
