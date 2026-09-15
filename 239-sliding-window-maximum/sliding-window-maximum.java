import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int right = 0; right < n; right++) {

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[right]) {

                deque.pollLast();
            }

            // Add current index
            deque.offerLast(right);

            // Remove indices outside the window
            if (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // Window has reached size k
            if (right >= k - 1) {

                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }

        return result;
    }
}