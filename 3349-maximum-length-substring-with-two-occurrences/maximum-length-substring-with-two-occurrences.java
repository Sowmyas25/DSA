class Solution {
    public int maximumLengthSubstring(String s) {
        // Use an array for O(1) character frequency tracking
        int[] charCounts = new int[26];
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Get the integer index for the character (0-25)
            int rightCharIndex = s.charAt(right) - 'a';
            charCounts[rightCharIndex]++;
            
            // Shrink the window if the current character count exceeds 2
            while (charCounts[rightCharIndex] > 2) {
                int leftCharIndex = s.charAt(left) - 'a';
                charCounts[leftCharIndex]--;
                left++;
            }
            
            // Update the maximum length found
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}