/************************
Problem Statement #

Design a class to calculate the median of a number stream. The class should have the following two methods:

    insertNum(int num): stores the number in the class
    findMedian(): returns the median of all numbers inserted in the class

If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

************************/
import java.util.*;

class MedianOfAStream {
  PriorityQueue<Integer> minHeap=new PriorityQueue<>();
  PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->(b-a));
  public void insertNum(int num) {
    if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        
        if(maxHeap.size()==minHeap.size())
            return;
        
        if(minHeap.size()>maxHeap.size())
            maxHeap.offer(minHeap.poll());
        else if(maxHeap.size()>minHeap.size()+1)
            minHeap.offer(maxHeap.poll());
  }

  public double findMedian() {
    if(minHeap.size()==maxHeap.size()) {
            return minHeap.peek()/2.0 + maxHeap.peek()/2.0;
        }
        
        else
           return maxHeap.peek();
  }

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}
