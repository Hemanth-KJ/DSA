import java.util.*;

class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of s1
        for (char ch : s1.toCharArray()) {
            s1Freq[ch - 'a']++;
        }

        int left = 0;
        int k = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            // Add current character
            windowFreq[s2.charAt(right) - 'a']++;

            // Keep window size equal to k
            if (right - left + 1 > k) {

                windowFreq[s2.charAt(left) - 'a']--;

                left++;
            }

            // Check if current window is a permutation
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}