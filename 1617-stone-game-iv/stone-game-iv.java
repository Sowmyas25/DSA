class Solution {
    public boolean winnerSquareGame(int n) {
        // dp[i] represents if the player can win with i stones left
        boolean[] dp = new boolean[n + 1];
        
        // Iterate through all stone counts from 1 to n
        for (int i = 1; i <= n; i++) {
            // Try removing every possible square number k * k
            for (int k = 1; k * k <= i; k++) {
                // If opponent faces a losing state, the current player wins
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break; // No need to check further moves for this state
                }
            }
        }
        
        return dp[n];
    }
}