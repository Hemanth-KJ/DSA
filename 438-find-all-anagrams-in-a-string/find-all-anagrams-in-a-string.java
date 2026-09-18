import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> result= new ArrayList<>();

         int[] pcount= new int[26];
         int[] windowcount=new int[26];

         for(char c: p.toCharArray()){
            pcount[c -'a']++;
         }

         int left=0;
         int k =p.length();

         for(int right=0; right<s.length(); right++){
            windowcount[s.charAt(right) -'a']++;

            if(right-left+1 > k){
                windowcount[s.charAt(left) -'a']--;
                left++;
            }

            if(Arrays.equals(pcount, windowcount)){
                result.add(left);
            }
         }
        return result;
    }
}