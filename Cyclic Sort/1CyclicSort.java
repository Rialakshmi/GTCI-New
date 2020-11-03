/******
Problem Statement #

We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence. This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number in O(n)O(n)O(n) and without any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.

Example 1:

Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]

Example 2:

Input: [2, 6, 4, 3, 1, 5]
Output: [1, 2, 3, 4, 5, 6]

Example 3:

Input: [1, 5, 6, 4, 3, 2]
Output: [1, 2, 3, 4, 5, 6]
*****/
class CyclicSort {

  public static void sort(int[] nums) {
    for(int i=0;i<nums.length;i++) {
      while(i+1!=nums[i]) {
        swap(nums,i,nums[i]-1);
      }
    }  
  }

  public static void swap(int[] nums,int i1,int i2) {
    int t1=nums[i1];
    nums[i1]=nums[i2];
    nums[i2]=t1;
  }
}
