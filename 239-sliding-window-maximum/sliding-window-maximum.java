import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

      int n = nums.length;
      Deque<Integer>deque= new ArrayDeque<>();
      int[] result = new int[n-k+1];
      int index=0;
      for(int right=0; right<n; right++){
       while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]){
        deque.pollLast();
       }
       deque.offerLast(right);

       if(deque.peekFirst() <= right-k){
       deque.pollFirst();
       }
       if(right >= k-1){
        result[index] = nums[deque.peekFirst()];
        index++;
       }
      }
      return result;
    }
}