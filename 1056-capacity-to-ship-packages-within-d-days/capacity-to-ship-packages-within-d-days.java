class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Find search range
        for (int weight : weights) {

            left = Math.max(left, weight);
            right += weight;
        }

        // Binary search
        while (left < right) {

            int capacity =
                left + (right - left) / 2;

            int daysNeeded = 1;
            int currentWeight = 0;

            // Check this capacity
            for (int weight : weights) {

                if (currentWeight + weight > capacity) {

                    daysNeeded++;
                    currentWeight = weight;

                } else {

                    currentWeight += weight;
                }
            }

            // Capacity is enough
            if (daysNeeded <= days) {

                right = capacity;

            } else {

                // Capacity is too small
                left = capacity + 1;
            }
        }

        return left;
    }
}