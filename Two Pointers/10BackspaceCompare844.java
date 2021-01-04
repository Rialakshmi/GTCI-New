
/***
Comparing Strings containing Backspaces (medium) #

Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Example 2:

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Example 3:

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.

Example 4:

Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
***/
class BackspaceCompare {

  public static boolean compare(String S, String T) {
     int sSkip=0,tSkip=0;
        int i=S.length()-1;
        int j=T.length()-1;
        while(i>=0 || j>=0) {
            while(i>=0) {
                if(S.charAt(i)=='#') {
                    sSkip++;i--;
                }else if(sSkip>0) {
                    sSkip--;i--;
                }else
                    break;                    
            }
            while(j>=0) {
                if(T.charAt(j)=='#') {
                    tSkip++;j--;
                }else if(tSkip>0) {
                    tSkip--;j--;
                }else
                    break;
            }
            
            if((i>=0&&j>=0)&&S.charAt(i)!=T.charAt(j))
                return false;
            
            if((i>=0) != (j>=0))
                return false;
            i--;j--;
        }
        
        return true;
  }
}
