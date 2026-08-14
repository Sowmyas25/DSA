class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'a']++;

            // If any character appears more than twice, shrink the window
            while (count[c - 'a'] > 2) {
                char leftChar = s.charAt(left);
                count[leftChar - 'a']--;
                left++;
            }

            // Now the window [left, right] is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
