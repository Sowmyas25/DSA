class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String best = "";
        int bestLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    ones++;
                }

                if (ones > k) {
                    break; // more 1's than k; cannot become exactly k again
                }

                if (ones == k) {
                    int len = j - i + 1;
                    String sub = s.substring(i, j + 1);
                    if (len < bestLen || (len == bestLen && sub.compareTo(best) < 0)) {
                        bestLen = len;
                        best = sub;
                    }
                }
            }
        }

        return best;
    }
}