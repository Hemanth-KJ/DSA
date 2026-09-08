class Solution {

    public boolean isPalindrome(String s) {

       int left = 0;
       int right = s.length()-1;
       while(left < right){
         while(left < right && !isAlphanumeric(s.charAt(left))){
            left++;
         }
         while(left < right && !isAlphanumeric(s.charAt(right))){
            right--;
         }
         if(tolowercase(s.charAt(left)) != tolowercase(s.charAt(right))){
            return false;
         }
         left++;
         right--;
       }
       return true;
    }
    private boolean isAlphanumeric(char c){
        return (c >='a' && c <='z')|| (c >='A' && c <='Z') || (c >='0' && c <='9');
    }
    private char tolowercase(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char) (c + ('a'-'A'));
        }
        return c;
    }
}