class Solution {
    public int maxVowels(String s, int k) {
        int vowelsCount=0;

        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                vowelsCount++;
            }
        }
        int maxVowels = vowelsCount;
         for(int right=k; right<s.length(); right++){
            if(isVowel(s.charAt(right))){
                vowelsCount++;
            }
            if(isVowel(s.charAt(right-k))){
                vowelsCount--;
            }
         
         maxVowels = Math.max(maxVowels, vowelsCount);
         }
      return maxVowels;
    }
    private boolean isVowel(char c){
        return c =='a' || 
               c =='e' ||
               c =='i' ||
               c =='o' ||
               c =='u';
    }
}