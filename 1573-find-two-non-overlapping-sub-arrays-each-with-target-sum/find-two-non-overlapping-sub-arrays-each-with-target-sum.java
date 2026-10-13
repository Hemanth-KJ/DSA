import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int minLen = INF;
        int answer = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink the window if sum exceeds target
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;

                // Combine with a subarray entirely before this window
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(
                        answer, length + best[left - 1]
                    );
                }

                minLen = Math.min(minLen, length);
            }

            // Best subarray length found up to index right
            best[right] = Math.min(
                minLen,
                right > 0 ? best[right - 1] : INF
            );
        }

        return answer == INF ? -1 : answer;
    }
}