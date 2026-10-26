class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] best= new int[arr.length];
        Arrays.fill(best, Integer.MAX_VALUE);

        int left=0;
        int sum=0;
        int answer=Integer.MAX_VALUE;
        int minlen=Integer.MAX_VALUE;
        
        for(int right=0; right < arr.length; right++){
            sum += arr[right];

          while(sum > target && left <= right){
            sum -= arr[left++];
          }
           if(sum == target){
            int len = right-left+1;
             if(left>0 && best[left-1] != Integer.MAX_VALUE){
                answer = Math.min(answer, len+best[left-1]);
             }
             minlen= Math.min(minlen, len);
           }

           best[right] =minlen;
        
        }
        return answer == Integer.MAX_VALUE ? -1: answer;

    }
}