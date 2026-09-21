import java.util.*;

class Solution {

    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1freq = new int[26];
        int[] windowfreq = new int[26];

        for(char c : s1.toCharArray()){
            s1freq[ c -'a']++;
        }
           
        int left=0;


        for(int right=0; right < s2.length(); right++){
          
          windowfreq[s2.charAt(right) -'a']++;

          if(right-left+1 > s1.length()){
            windowfreq[s2.charAt(left) - 'a']--;  
            left++;   
          }
           if(Arrays.equals(windowfreq, s1freq)){
            return true;
           }
        }
       return false;
    }
}