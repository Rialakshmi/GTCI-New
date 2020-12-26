/**
Problem Statement #

Given a string, find the length of the longest substring in it with no more than K distinct characters.
Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
**/
import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    int max=-1;
    int j=0;
    HashMap<Character,Integer> hm=new HashMap<>();
    for(int i=0;i<str.length();i++) {
      char right=str.charAt(i);
      hm.put(right,hm.getOrDefault(right,0)+1);
      while(hm.size()>k) {
        char left=str.charAt(j++);
        hm.put(left,hm.get(left)-1);
        if(hm.get(left)==0)
        hm.remove(left);
      }
      if(hm.size()==k) {
        max=Math.max(max,i-j+1);
      }
    }
    return max;
  }
}
