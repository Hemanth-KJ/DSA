class Solution {

    public int lengthOfLongestSubstring(String s) {

        int[] lastIndex = new int[256];

        int left = 0;
        int maxLength = 0;

        for (int right =0; right<s.length(); right++){
            char currchar = s.charAt(right);

            if(lastIndex[currchar]>0){
                left=Math.max(left, lastIndex[currchar]);
            }
            lastIndex[currchar]=right+1;
            maxLength =Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}