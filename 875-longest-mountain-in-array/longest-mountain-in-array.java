class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;
        int i = 1;

        while (i < n - 1) {

            // Check whether arr[i] is a peak
            if (arr[i] > arr[i - 1] &&
                arr[i] > arr[i + 1]) {

                int left = i;
                int right = i;

                // Expand left while strictly increasing
                while (left > 0 &&
                       arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand right while strictly decreasing
                while (right < n - 1 &&
                       arr[right] > arr[right + 1]) {
                    right++;
                }

                longest = Math.max(longest, right - left + 1);

                // Continue after this mountain
                i = right;
            } else {
                i++;
            }
        }

        return longest;
    }
}