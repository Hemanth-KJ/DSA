class Solution {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters
            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            // Compare ignoring uppercase/lowercase
            if (toLower(s.charAt(left)) != toLower(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {

        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }

    private char toLower(char c) {

        if (c >= 'A' && c <= 'Z') {
            return (char) (c + ('a' - 'A'));
        }

        return c;
    }
}