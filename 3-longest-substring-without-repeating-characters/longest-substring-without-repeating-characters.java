class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int left=0;
        int right=0;
        int maxlength =0;
        while(right < s.length()){
          char currchar =s.charAt(right);
          int currcharAscii= (int) currchar;

          arr[currcharAscii] =arr[currcharAscii]+1;

          while(arr[currcharAscii] > 1){
            char currleft =s.charAt(left);
            int leftcharAScii = (int) currleft;

           arr[leftcharAScii] =arr[leftcharAScii]-1; 

            left++;
          }
           int maxsize = right -left + 1;
         if(maxsize > maxlength){
            maxlength =maxsize;
        }
          right++;
        }
    return maxlength;
    }
}