class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        for(int i=0; i<s.length(); i++){
         last[s.charAt(i) - 'a']=i;
        }

        List<Integer> result=new ArrayList<>();
         
        int startindex=0;
        int endindex=0;
        for(int i=0; i<s.length(); i++){
            endindex= Math.max(endindex, last[s.charAt(i)-'a']);

            if(i==endindex){
                result.add(endindex-startindex+1);
                startindex=i+1;
            }
        }
        return result;
    }
}