class Solution {
    public List<Integer> partitionLabels(String s) {
         List<Integer> result = new ArrayList<>();

         for(int i=0; i<s.length();){
            int startindex=i;
            int endindex= s.lastIndexOf(s.charAt(startindex));

            for(int search=startindex+1; search <=endindex-1; search++){
                int lastindexofnextchar= s.lastIndexOf(s.charAt(search));

                if(lastindexofnextchar > endindex){
                    endindex= lastindexofnextchar;
                }
            }
            result.add(endindex-startindex + 1);
            i=endindex+1;
         }
         return result;
    }
}