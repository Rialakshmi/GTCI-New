/**
Problem Statement #

Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

Example 1:

Input: [-1, 0, 2, 3], target=3 
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Example 2:

Input: [-1, 4, 2, 1, 3], target=5 
Output: 4
Explanation: There are four triplets whose sum is less than the target: 
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
**/
import java.util.*;

class TripletWithSmallerSum {

  public static int searchTriplets(int[] nums, int target) {
    Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++) {
            int lo=i+1;
            int hi=nums.length-1;
            while(lo<hi) {
                int currSum=nums[i]+nums[lo]+nums[hi];
                if(currSum<target) {
                    count+=hi-lo;
                    lo++;
                }else {
                    hi--;
                }
            }
        }
        
        return count;
  }
}
