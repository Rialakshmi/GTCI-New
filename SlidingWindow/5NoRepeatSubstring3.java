/***
Problem Statement #

Given a string, find the length of the longest substring which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Example 2:

Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".

Example 3:

Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
****/
import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    int j=0;
    int max=0;
    HashSet<Character> hs=new HashSet<>();
    for(int i=0;i<str.length();i++) {
      char right=str.charAt(i);
      while(hs.contains(right)) {
        char left=str.charAt(j++);
        hs.remove(left);
      }
      hs.add(right);
      max=Math.max(max,i-j+1);
    }
    return max;
  }
}
