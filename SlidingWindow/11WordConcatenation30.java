/**
Words Concatenation (hard) #

Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.

Example 1:

Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Example 2:

Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".
**/
import java.util.*;

class WordConcatenation {
  public static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    HashMap<String,Integer> wm=new HashMap<>();
    for(String word:words)
    wm.put(word,wm.getOrDefault(word,0)+1);
    int wL=words[0].length();
    int tW=words.length;
    int twL=words.length*wL;
    for(int i=0;i<=str.length()-twL;i++) {
      HashMap<String,Integer> temp=new HashMap<>();
      for(int j=0;j<tW;j++) {
        int sI=i+j*wL;
        String sub=str.substring(sI,sI+wL);
        if(!wm.containsKey(sub))
        break;
        temp.put(sub,temp.getOrDefault(sub,0)+1);
        if(temp.get(sub)>wm.get(sub))
        break;
        if(j+1==tW)
        resultIndices.add(i);
      }
    }
    return resultIndices;
  }
}
