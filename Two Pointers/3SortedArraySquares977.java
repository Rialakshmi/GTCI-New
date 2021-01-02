/***
Problem Statement #

Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Example 2:

Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]


***/
class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
     int[] squares = new int[arr.length];
    int i=squares.length-1;
    int lo=0,hi=arr.length-1;
    while(lo<=hi) {
       if(arr[lo]*arr[lo]>arr[hi]*arr[hi]) {
        squares[i--]=arr[lo]*arr[lo];
        lo++;
      }else {
        squares[i--]=arr[hi]*arr[hi];
        hi--;
      }
    }
    return squares;
  }
}
