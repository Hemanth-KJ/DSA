class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;
        for(int right=0; right  < s.length(); right++){
            if(right >=2){
             char a = s.charAt(right-2); 
             char b = s.charAt(right-1); 
             char c = s.charAt(right);
            if(a != b && a != c && b != c){
                count++;
            }
        }
    }
    return count;
    }
}