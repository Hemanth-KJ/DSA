import java.util.*;

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

       List<Integer> result = new ArrayList<>();

       if(s == null || words == null || words.length == 0){
        return result;
       }

       int wordlength = words[0].length();
       int wordcount = words.length;
       int totallength = wordcount * wordlength;
       
       if(s.length()<totallength){
        return result;
       }

       Map<String, Integer> target= new HashMap<>();

       for(String word : words){
        target.put(word, target.getOrDefault(word, 0)+1);
       }

       for(int offset=0; offset < wordlength; offset++){
        int left =offset;
        int right=offset;
        int count=0;

        Map<String, Integer> window= new HashMap<>();

        while(right + wordlength <=s.length()){
            String word=s.substring(right, right+wordlength);

            right+=wordlength;

            if(!target.containsKey(word)){
                window.clear();
                count =0;
                left =right;

                continue;
            }

            window.put(word, window.getOrDefault(word, 0)+1);

            count++;
            while(window.get(word) > target.get(word)){
                String leftword=s.substring(left, left+wordlength);
                window.put(leftword, window.get(leftword)-1);
                left+=wordlength;
                count--;
            }
            if(count ==wordcount){
                result.add(left);
                String leftword=s.substring(left, left+wordlength);
                window.put(leftword, window.get(leftword)-1);
                left+=wordlength;
                count--;
            }
        }
       }


        return result;
    }
}