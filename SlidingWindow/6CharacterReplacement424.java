/**
Problem Statement #

Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".

Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".

Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
**/
class CharacterReplacement {
  public static int findLength(String str, int k) {
    int j=0;
    int max=0;
    HashMap<Character,Integer> hm=new HashMap<>();
    for(int i=0;i<str.length();i++) {
      char right=str.charAt(i);
      hm.put(right,hm.getOrDefault(right,0)+1);
      while(hm.size()>2 || (hm.size()==2&&bothGreaterThanK(hm,k))) {
        char left=str.charAt(j);
        if(hm.get(left)==1)
          hm.remove(left);
        else
          hm.put(left,hm.get(left)-1);
          j++;
      }
      max=Math.max(max,i-j+1);
    }
    return max;
  }

  public static boolean bothGreaterThanK(HashMap<Character,Integer> hm,int k) {
    boolean greaterThanK=false;
    for(Integer val:hm.values()) {
      if(val>k) {
        if(greaterThanK)
          return true;
        greaterThanK=true;
      }
    }
    return false;
  }
}
