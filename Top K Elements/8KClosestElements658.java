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
    List<Integer> input=new ArrayList<>();
        for(int num:arr)
            input.add(num);
        Collections.sort(input,(a,b)->(Math.abs(a-x)-Math.abs(b-x)));
        List<Integer> output=input.subList(0,k);
        Collections.sort(output);
        return output;
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
