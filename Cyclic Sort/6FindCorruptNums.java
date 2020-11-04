/****
Find the Corrupt Pair (easy) #

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

Example 1:

Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.

Example 2:

Input: [3, 1, 2, 3, 6, 4]
Output: [3, 5]
Explanation: '3' is duplicated and '5' is missing.
*****/
class FindCorruptNums {

  public static int[] findNumbers(int[] nums) {
    // TODO: Write your code here
    for(int i=0;i<nums.length;i++) {
      while(nums[i]!=i+1) {
        if(nums[i]==nums[nums[i]-1])
        break;
        swap(nums,i,nums[i]-1);
      }
    }
    int res[]={-1, -1};
    int j=0;
    for(int i=0;i<nums.length;i++) {
      if(nums[i]!=i+1) {
        res[0]=nums[i];
        res[1]=i+1;
      }
    }
    return res;
  }

  public static void swap(int[] nums,int i1,int i2) {
    int temp=nums[i1];
    nums[i1]=nums[i2];
    nums[i2]=temp;
  }
}
