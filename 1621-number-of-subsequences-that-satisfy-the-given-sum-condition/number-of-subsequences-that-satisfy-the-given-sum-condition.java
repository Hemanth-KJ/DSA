import java.util.*;

class Solution {

    public int numSubseq(int[] nums, int target) {

        int MOD = 1_000_000_007;

        Arrays.sort(nums);

        int n = nums.length;

        // powers[i] = 2^i
        int[] powers = new int[n];

        powers[0] = 1;

        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }

        int left = 0;
        int right = n - 1;

        long answer = 0;

        while (left <= right) {

            if (nums[left] + nums[right] <= target) {

                // Number of valid subsequences
                answer += powers[right - left];

                answer %= MOD;

                left++;

            } else {

                right--;
            }
        }

        return (int) answer;
    }
}