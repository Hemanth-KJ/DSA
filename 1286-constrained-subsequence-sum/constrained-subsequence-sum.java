class Solution {

    public int constrainedSubsetSum(int[] nums, int k) {
        
      int[] dp= new int[nums.length];

      Deque<Integer> deque= new ArrayDeque<>();

      int answer=Integer.MIN_VALUE;

      for(int i=0; i<nums.length; i++){
       while(!deque.isEmpty() && deque.peekFirst() < i-k){
        deque.pollFirst();
       }

       if(deque.isEmpty()){
        dp[i] =nums[i];
       }
       else{
        dp[i] = nums[i] + Math.max(0, dp[deque.peekFirst()]);
       }
       answer =Math.max(answer, dp[i]);
       
       while(!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]){
        deque.pollLast();
       }
       deque.offerLast(i);
    }
    return answer == 0 ? -1 :answer;
    }
}