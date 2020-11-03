/****
Problem Statement #

We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

Input: [4, 0, 3, 1]
Output: 2

Example 2:

Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
*****/
class MissingNumber {

  public static int findMissingNumber(int[] nums) {
    for(int i=0;i<nums.length;i++) {
      while(i+1!=nums[i]&&nums[i]!=0) {
        swap(nums,i,nums[i]-1);
      }
    }

    for(int i=0;i<nums.length;i++) {
      if(nums[i]!=(i+1))
      return i+1;
    }
    return -1;
  }

  public static void swap(int[] nums,int i1,int i2) {
    int temp=nums[i1];
    nums[i1]=nums[i2];
    nums[i2]=temp;
  }
}
