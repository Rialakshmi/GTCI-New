/**
Problem Statement #

Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

Example 2:

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
**/
import java.util.*;

class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] nums) {
     Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            if(i==0 ||(i>0&&nums[i-1]!=nums[i])) {
                int target=-nums[i];
                int lo=i+1;
                int hi=nums.length-1;
                while(lo<hi) {
                    if(nums[lo]+nums[hi]==target) {
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[lo]);temp.add(nums[hi]);
                        list.add(temp);
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++; hi--;
                    }else if(nums[lo]+nums[hi]>target) {
                        hi--;
                    }else {
                        lo++;
                    }
                }
            }
        }
        
        return list;
  }
}
