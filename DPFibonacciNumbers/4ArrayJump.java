/********
Problem Statement #

Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element, write a program to find the minimum number of jumps needed to reach the end of the array (starting from the first element). If an element is 0, then we cannot move through that element.

Example 1:

Input = {2,1,1,1,4}
Output = 3
Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4

Example 2:

Input = {1,1,3,6,9,3,0,1,3}
Output = 4
Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8

Let’s first start with a recursive brute-force solution.
*********/
class ArrayJump {

  public int countMinJumps(int[] jumps) {
    int[] dp = new int[jumps.length];

    //initialize with infinity, except the first index which should be zero as we start from there
    for(int i=1; i<jumps.length; i++)
      dp[i] = Integer.MAX_VALUE;

    for(int start=0; start < jumps.length-1; start++) {
      for(int end=start+1; end <= start+jumps[start] && end < jumps.length; end++)
        dp[end] = Math.min(dp[end], dp[start]+1);
    }

    return dp[jumps.length-1];
  }

  public static void main(String[] args) {
    ArrayJump aj = new ArrayJump();
    int[] jumps = {2, 1, 1, 1, 4};
    System.out.println(aj.countMinJumps(jumps));
    jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
    System.out.println(aj.countMinJumps(jumps));
  }
}
