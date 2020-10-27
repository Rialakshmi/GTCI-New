/**
Quadruple Sum to Target (medium) #

Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.

Example 1:

Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.

Example 2:

Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
**/
import java.util.*;

class QuadrupleSumToTarget {

  public static List<List<Integer>> searchQuadruplets(int[] nums, int target) {
       Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(i==0 || nums[i-1]!=nums[i]) {
              for(int j=i+1;j<nums.length;j++) {
                if(j==i+1 || nums[j-1]!=nums[j]) {
                    int lo=j+1;
                    int hi=nums.length-1;
                    while(lo<hi) {
                        int sum=nums[i]+nums[j]+nums[lo]+nums[hi];
                        if(sum==target) {
                            List<Integer> temp=new ArrayList<>();
                            temp.add(nums[i]);temp.add(nums[j]);
                            temp.add(nums[lo]);temp.add(nums[hi]);
                            list.add(temp);
                            lo++;hi--;
                            while(lo<hi&&nums[lo]==nums[lo-1])
                                lo++;
                            while(lo<hi&&nums[hi]==nums[hi+1])
                                hi--;
                            
                        }else if(sum>target)
                            hi--;
                        else
                            lo++;
                    }
                }
                }  
            }
            
        }
        
        return list;
  }
}
