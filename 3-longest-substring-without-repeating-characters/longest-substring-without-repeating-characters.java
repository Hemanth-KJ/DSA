class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxlength = 0;

        while (right < s.length()) {

            char currchar = s.charAt(right);
            if(map.containsKey(currchar)){
                int lastIndex= map.get(currchar);
                int nextleft = lastIndex+1;

                if(nextleft>left){
                    left = nextleft;
                }
            }

            map.put(currchar, right);

            int maxsize = right - left + 1;

            if (maxsize > maxlength) {
                maxlength = maxsize;
            }

            right++;
        }

        return maxlength;
    }
}