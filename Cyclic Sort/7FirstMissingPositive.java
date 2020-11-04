/*****
Find the Smallest Missing Positive Number (medium) #

Given an unsorted array containing numbers, find the smallest missing positive number in it.

Example 1:

Input: [-3, 1, 5, 4, 2]
Output: 3
Explanation: The smallest missing positive number is '3'

Example 2:

Input: [3, -2, 0, 1, 2]
Output: 4

Example 3:

Input: [3, 2, 5, 1]
Output: 4
******/
class FirstMissingPositive {

  public static int findNumber(int[] nums) {
     if(nums==null)
            return 0;
        
        for(int i=0;i<nums.length;i++) {
            
            while(nums[i]-1>=0&&nums[i]-1<nums.length&&nums[i]!=i+1) {
                if(nums[i]==nums[nums[i]-1])
                    break;
                swap(nums,i,nums[i]-1);
            }
        }
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return nums.length+1;
  }

  public static void swap(int[] nums,int i1,int i2) {
        int temp=nums[i1];
        nums[i1]=nums[i2];
        nums[i2]=temp;
    }
}
