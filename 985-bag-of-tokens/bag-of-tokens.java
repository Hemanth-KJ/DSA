import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (left <= right) {
            if (power >= tokens[left]) {
                // Play cheapest token face up
                power -= tokens[left];
                left++;
                score++;

                maxScore = Math.max(maxScore, score);

            } else if (score > 0) {
                // Play most expensive token face down
                power += tokens[right];
                right--;
                score--;

            } else {
                break;
            }
        }

        return maxScore;
    }
}