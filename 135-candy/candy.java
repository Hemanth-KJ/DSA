class Solution {

    public int candy(int[] ratings) {

        int n = ratings.length;

        int total = 1;
        int i = 1;

        while (i < n) {

            if (ratings[i] == ratings[i - 1]) {
                total++;
                i++;
                continue;
            }

            int peak = 1;

            // Increasing slope
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                total += peak;
                i++;
            }

            int down = 1;

            // Decreasing slope
            while (i < n && ratings[i] < ratings[i - 1]) {
                total += down;
                down++;
                i++;
            }

            if (down > peak) {
                total += down - peak;
            }
        }

        return total;
    }
}