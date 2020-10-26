/***
Smallest Window containing Substring (hard) #

Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

Example 1:

Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Example 2:

Input: String="abdbca", Pattern="abc"
Output: "bca"
Explanation: The smallest substring having all characters of the pattern is "bca".

Example 3:

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.
***/
import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    HashMap<Character,Integer> hm=new HashMap<>();
    for(char c:pattern.toCharArray()) {
        hm.put(c,hm.getOrDefault(c,0)+1);
    }

    int min=Integer.MAX_VALUE;
    int start=0;
    int j=0;
    int matchCount=0;
    for(int i=0;i<str.length();i++) {
        char right=str.charAt(i);
        if(hm.containsKey(right)) {
            
                hm.put(right,hm.get(right)-1);
                if(hm.get(right)==0)
                    matchCount++;
            
        }
        while(matchCount==hm.size()) {
            char left=str.charAt(j);
            if(min>i-j+1) {
                min=i-j+1;
                start=j;
            }
            if(hm.containsKey(left)) {
                if(hm.get(left)==0)
                matchCount--;
                hm.put(left,hm.get(left)+1);
            }
            j++;
        }
    }
    return min==Integer.MAX_VALUE?"":str.substring(start,start+min);
  }
}
