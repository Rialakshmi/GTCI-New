/**
Problem Statement #

Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.

Example 1:

Input: [2, 5, 3, 10], target=30 
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.

Example 2:

Input: [8, 2, 6, 5], target=50 
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5] 
Explanation: There are seven contiguous subarrays whose product is less than the target.
**/
import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] nums, int k) {
    List<List<Integer>> subarrays = new ArrayList<>();
    int j=0;
        int mult=1;
        int count=0;
        for(int i=0;i<nums.length;i++) {
            
            mult*=nums[i];
            while(j<i&&mult>=k) 
                mult/=nums[j++];
            if(mult<k)
            count+=i-j+1;
            List<Integer> temp=new ArrayList<>();
            for(int z=i;z>=j&&mult<k;z--) {
              temp.add(0,nums[z]);
              subarrays.add(new ArrayList<Integer>(temp));
            }

        }
        
        
    return subarrays;
  }
}
