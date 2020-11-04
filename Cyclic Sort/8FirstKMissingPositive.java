/****
Find the First K Missing Positive Numbers (hard) #

Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

Example 1:

Input: [3, -1, 4, 5, 5], k=3
Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.

Example 2:

Input: [2, 3, 4], k=3
Output: [1, 5, 6]
Explanation: The smallest missing positive numbers are 1, 5 and 6.

Example 3:

Input: [-2, -3, 4], k=2
Output: [1, 2]
Explanation: The smallest missing positive numbers are 1 and 2.
*****/
import java.util.*;

class FirstKMissingPositive {

  public static List<Integer> findNumbers(int[] nums, int k) {
    List<Integer> missingNumbers = new ArrayList<>();
    Set<Integer> extraNumbers=new HashSet<>();
    for(int i=0;i<nums.length;i++) {
      while(nums[i]-1>=0&&nums[i]-1<nums.length&&nums[i]-1!=i) {
        if(nums[i]==nums[nums[i]-1])
        break;
        swap(nums,i,nums[i]-1);
      }
    }

    for(int i=0;i<nums.length;i++) {
      if(nums[i]!=i+1&&missingNumbers.size()<k) {
        missingNumbers.add(i+1);
        extraNumbers.add(nums[i]);
      }
      
    }
    int i=1;
    while(missingNumbers.size()<k) {
      if(!extraNumbers.contains(nums.length+i))
      missingNumbers.add(nums.length+i);
      i++;
    }
    return missingNumbers;
  }

  public static void swap(int[] nums,int i1,int i2) {
    int temp=nums[i1];
    nums[i1]=nums[i2];
    nums[i2]=temp;
  }
}
