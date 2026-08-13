class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] required = new int[128];
        int[] window = new int[128];

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            required[c]++;
        }

        int left = 0;
        int right = 0;

        int matched = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {

            char current = s.charAt(right);

            window[current]++;

            // Current character is useful
            if (required[current] > 0 &&
                window[current] <= required[current]) {

                matched++;
            }

            right++;

            // Try to shrink the window
            while (matched == t.length()) {

                int currentLength = right - left;

                // Update minimum window
                if (currentLength < minLength) {

                    minLength = currentLength;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                window[leftChar]--;

                // Removing a required character
                if (required[leftChar] > 0 &&
                    window[leftChar] < required[leftChar]) {

                    matched--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex,
                           startIndex + minLength);
    }
}