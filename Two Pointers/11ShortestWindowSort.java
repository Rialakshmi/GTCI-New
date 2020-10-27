/**
Minimum Window Sort (medium) #

Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

Example 1:

Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

Example 2:

Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted

Example 3:

Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted

Example 4:

Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted.
**/
class ShortestWindowSort {

  public static int sort(int[] nums) {
     int lo=0;
        int hi=nums.length-1;
        while(lo+1<nums.length&&nums[lo]<=nums[lo+1])
            lo++;
        if(lo==nums.length-1)
            return 0;
        while(hi-1>=0&&nums[hi]>=nums[hi-1])
            hi--;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        if(hi<nums.length)
        for(int i=lo;i<=hi;i++) {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        
        while(lo-1>=0&&nums[lo-1]>min)
            lo--;
        while(hi+1<nums.length&&nums[hi+1]<max)
            hi++;
        
        return hi-lo+1;
  }
}
