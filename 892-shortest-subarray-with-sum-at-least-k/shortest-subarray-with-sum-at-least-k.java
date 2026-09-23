class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        
        long[] prefix= new long[n+1];
      
        for(int i=0; i<n; i++){
            prefix[i+1]= prefix[i]+nums[i];
        }
        
        Deque<Integer> deque= new ArrayDeque<>();
         int answer=n+1;
        for(int right=0; right<=n; right++){
         while(!deque.isEmpty() && prefix[right] - prefix[deque.peekFirst()] >= k){
            int left = deque.pollFirst();

            answer= Math.min(answer, right-left);
         }
         while(!deque.isEmpty() && prefix[right] <= prefix[deque.peekLast()] ){
            deque.pollLast();
         }
         deque.offerLast(right);
        }
        return answer == n+1 ? -1 :answer;
    }
}