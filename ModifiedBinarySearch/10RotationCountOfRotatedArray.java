/**** 
Rotation Count (medium) #

Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.

You can assume that the array does not have any duplicates.

Example 1:

Input: [10, 15, 1, 3, 8]
Output: 2
Explanation: The array has been rotated 2 times.
Example 2:

Input: [4, 5, 7, 9, 10, -1, 2]
Output: 5
Explanation: The array has been rotated 5 times.
*****/
class RotationCountOfRotatedArray {

  public static int countRotations(int[] arr) {
   // TODO: Write your code here
   int start = 0;
   int end = arr.length - 1;
   while(start<end) {
     int middle = start + (end-start) / 2;
     if(middle>start && arr[middle-1] > arr[middle])
     return middle;
     if(end>middle && arr[middle+1] < arr[middle])
     return middle+1;

     if(arr[start]<arr[middle]) {
       start = middle+1;
     } else
     end = middle -1;
   }
    return 0; 
  }

  public static void main(String[] args) {
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
  }
}
