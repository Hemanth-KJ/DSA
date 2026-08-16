class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary search
        while (left < right) {

            int mid = left + (right - left) / 2;

            long totalHours = 0;

            // Calculate hours for this speed
            for (int pile : piles) {

                totalHours +=
                    (pile + mid - 1) / mid;
            }

            // Speed is enough
            if (totalHours <= h) {

                right = mid;

            } else {

                // Speed is too slow
                left = mid + 1;
            }
        }

        return left;
    }
}