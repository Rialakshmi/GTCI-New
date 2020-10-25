/***
Permutation in a String (hard) #

Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

    abc
    acb
    bac
    bca
    cab
    cba

If a string has ‘n’ distinct characters it will have n!n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
***/
import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    HashMap<Character,Integer> hm=new HashMap<>();
    for(char c:pattern.toCharArray()) {
      hm.put(c,hm.getOrDefault(c,0)+1);
    }

    int matchCount=0;
    int j=0;
    for(int i=0;i<str.length();i++) {
      char right=str.charAt(i);
      if(hm.containsKey(right)) {
        hm.put(right,hm.get(right)-1);
        if(hm.get(right)==0)
        matchCount++;
      }
      if(i>pattern.length()-1) {
        char left=str.charAt(j++);
        if(hm.containsKey(left)) {
          if(hm.get(left)==0)
          matchCount--;
          hm.put(left,hm.get(left)+1);
        }
      }
      if(hm.size()==matchCount)
      return true;
    }
    return false;
  }
}
