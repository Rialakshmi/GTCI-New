/************
Problem Statement #

Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.

Example 1:

Input: [5, 6, 7, 8, 9], K = 3, X = 7
Output: [6, 7, 8]

Example 2:

Input: [2, 4, 5, 6, 9], K = 3, X = 6
Output: [4, 5, 6]

Example 3:

Input: [2, 4, 5, 6, 9], K = 3, X = 10
Output: [5, 6, 9]

***************/
import java.util.*;
import java.util.stream.Collectors;

class Entry {
  int key;
  int value;

  public Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class KClosestElements {

  public static List<Integer> findClosestElements(int[] arr, int k, Integer x) {
    int low=0;
     int high=arr.length-k;
     while(low<high) {
         int mid=low+(high-low)/2;
         if(x-arr[mid]>arr[mid+k]-x)
             low=mid+1;
         else
             high=mid;
     }
        
        return Arrays.stream(arr,low,low+k).boxed().collect(Collectors.toList());
  }

  public static int binarySearch(int[] arr,int target) {
    int low=0;
    int high=arr.length-1;
    while(low<=high) {
      int mid=low+(high-low)/2;
      if(arr[mid]==target)
      return mid;
      else if(arr[mid]>target)
      high=mid-1;
      else
      low=mid+1;
    }
    if(low>0)
    return low-1;
    else
    return low;
  }

  public static void main(String[] args) {
    List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);
  }
}
