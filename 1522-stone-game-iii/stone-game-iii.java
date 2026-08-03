class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        
        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stoneValue[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE;
            
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                int taken = pref[i + k] - pref[i];                         int opponentAdvantage = dp[i + k];         
                best = Math.max(best, taken - opponentAdvantage);
            }
            dp[i] = best;
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}