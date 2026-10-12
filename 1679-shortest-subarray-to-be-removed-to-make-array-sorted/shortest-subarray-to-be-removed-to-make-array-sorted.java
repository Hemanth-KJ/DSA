class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Find the longest sorted prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // Already sorted
        if (left == n - 1) {
            return 0;
        }

        // Find the longest sorted suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Remove either the suffix or the prefix
        int answer = Math.min(n - left - 1, right);

        // Try connecting the sorted prefix and suffix
        int i = 0;
        int j = right;

        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                answer = Math.min(answer, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return answer;
    }
}