/****

Cycle in a Circular Array (hard) #

We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices. You should assume that the array is circular which means two things:

    If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
    If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.

Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.

Example 1:

Input: [1, 2, -1, 2, 2]
Output: true
Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0

Example 2:

Input: [2, 2, -1, 2]
Output: true
Explanation: The array has a cycle among indices: 1 -> 3 -> 1

Example 3:

Input: [2, 1, -1, -2]
Output: false
Explanation: The array does not have any cycle.
****/
class CircularArrayLoop {

  public static boolean loopExists(int[] nums) {
     for(int i=0;i<nums.length;i++) {
            int slow = i;
            int fast = i;
            boolean isForward=nums[i]>=0;
            do {
                slow = move(nums,isForward,slow);
                fast = move(nums,isForward,fast);
                if(fast!=-1)
                    fast=move(nums,isForward,fast);
            } while(slow!=fast&&slow!=-1&&fast!=-1);
            if(fast==slow&&slow!=-1)
                return true;
        }
        
        return false;
  }

   public static int move(int[]nums, boolean currentDirection,int currIndex) {
        boolean nextDirection=nums[currIndex]>=0;
        if(currentDirection!=nextDirection)
            return -1;
        int nextIndex = (currIndex +nums[currIndex]) % nums.length;
        if(nextIndex<0)
            nextIndex += nums.length;
        if(nextIndex==currIndex)
            return -1;
        return nextIndex;
    }

  public static void main(String[] args) {
    System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
    System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
    System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
  }
}
