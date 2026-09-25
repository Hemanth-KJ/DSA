import java.util.*;

class Solution {

    public int constrainedSubsetSum(int[] nums, int k) {

        int n = nums.length;

        int[] dp = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            // 1. Remove indices outside the window
            while (!deque.isEmpty()
                    && deque.peekFirst() < i - k) {

                deque.pollFirst();
            }

            // 2. Calculate dp[i]
            if (deque.isEmpty()) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + Math.max(0, dp[deque.peekFirst()]);
            }

            // 3. Update answer
            answer = Math.max(answer, dp[i]);

            // 4. Remove smaller DP values
            while (!deque.isEmpty()
                    && dp[deque.peekLast()] <= dp[i]) {

                deque.pollLast();
            }

            // 5. Add current index
            deque.offerLast(i);
        }

        return answer;
    }
}