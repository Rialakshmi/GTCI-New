/**
Problem Statement #

Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.

Example 1:

Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]

Example 2:

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]
**/
class DutchFlag {

  public static void sort(int[] arr) {
    // TODO: Write your code here   
    int lo=0,hi=arr.length-1;
    for(int i=0;i<=hi;) {
      if(arr[i]==0) {
        if(i!=lo)
        swap(arr,i,lo);
        lo++;
        i++;
      }else if(arr[i]==1) {
        i++;
      }else {
        if(hi!=i) 
        swap(arr,i,hi);
        hi--;
      }
    }
  }

  public static void swap(int[] arr,int i,int j) {
    int temp=arr[j];
    arr[j]=arr[i];
    arr[i]=temp;
  }
}
