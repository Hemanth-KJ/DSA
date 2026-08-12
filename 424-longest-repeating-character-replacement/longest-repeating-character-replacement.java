class Solution {

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            int index = s.charAt(right) - 'A';

            freq[index]++;

            // Update highest frequency
            maxFrequency = Math.max(
                maxFrequency,
                freq[index]
            );

            // Current window size
            int windowLength = right - left + 1;

            // Characters that need replacement
            int replacements = windowLength - maxFrequency;

            // If more than k replacements are needed
            if (replacements > k) {

                int leftIndex = s.charAt(left) - 'A';

                freq[leftIndex]--;

                left++;
            }

            // Update answer
            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}