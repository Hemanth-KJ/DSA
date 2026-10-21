import java.util.Arrays;

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);

        int n = arr.length;
        long count = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    if (arr[left] == arr[right]) {
                        int len = right - left;
                        count += (long) len * (len + 1) / 2;
                        count %= MOD;
                        break;
                    } else {
                        int leftValue = arr[left];
                        int rightValue = arr[right];
                        long leftCount = 0;
                        long rightCount = 0;

                        while (left < right && arr[left] == leftValue) {
                            left++;
                            leftCount++;
                        }

                        while (left <= right && arr[right] == rightValue) {
                            right--;
                            rightCount++;
                        }

                        count += leftCount * rightCount;
                        count %= MOD;
                    }
                }
            }
        }

        return (int) count;
    }
}