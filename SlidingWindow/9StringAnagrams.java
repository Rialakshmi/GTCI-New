/**
String Anagrams (hard) #

Given a string and a pattern, find all anagrams of the pattern in the given string.

Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:

    abc
    acb
    bac
    bca
    cab
    cba

Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Example 1:

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Example 2:

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
**/
import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    HashMap<Character,Integer> hm=new HashMap<>();
    for(char c:pattern.toCharArray())
    hm.put(c,hm.getOrDefault(c,0)+1);
    int matchCount=0;
    int j=0;
    for(int i=0;i<str.length();i++) {
        char right=str.charAt(i);
        if(hm.containsKey(right)) {
            hm.put(right,hm.get(right)-1);
            if(hm.get(right)==0)
            matchCount++;
        }
        if(i+1-j>pattern.length()) {
            char left=str.charAt(j++);
            if(hm.containsKey(left)) {
                if(hm.get(left)==0)
                matchCount--;
                hm.put(left,hm.get(left)+1);
            }
        }

        if(hm.size()==matchCount) {
            resultIndices.add(j);
        }
    }
    return resultIndices;
  }
}
