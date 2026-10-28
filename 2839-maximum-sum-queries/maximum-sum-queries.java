
import java.util.Arrays;

class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int m = queries.length;

        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = nums1[i];
            points[i][1] = nums2[i];
        }

        Arrays.sort(points, (a, b) -> Integer.compare(b[0], a[0]));

        int[][] qs = new int[m][3];
        for (int i = 0; i < m; i++) {
            qs[i][0] = queries[i][0];
            qs[i][1] = queries[i][1];
            qs[i][2] = i;
        }

        Arrays.sort(qs, (a, b) -> Integer.compare(b[0], a[0]));

        int[] ans = new int[m];
        int[] stackY = new int[n];
        int[] stackSum = new int[n];
        int top = -1;
        int p = 0;

        for (int[] q : qs) {
            int x = q[0];
            int y = q[1];

            while (p < n && points[p][0] >= x) {
                int py = points[p][1];
                int sum = points[p][0] + py;

                while (top >= 0 && stackSum[top] <= sum) {
                    top--;
                }

                if (top < 0 || stackY[top] < py) {
                    stackY[++top] = py;
                    stackSum[top] = sum;
                }

                p++;
            }

            int left = 0, right = top;
            int best = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (stackY[mid] >= y) {
                    best = stackSum[mid];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            ans[q[2]] = best;
        }

        return ans;
    }
}
