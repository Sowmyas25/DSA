class Solution {
    public long countCommas(long n) {
          long ans = 0;
        long start = 1;      // smallest number with current number of digits
        int digits = 1;

        while (start <= n) {
            long end = Math.min(n, start * 10 - 1);
            long count = end - start + 1;

            // Numbers with d digits have (d - 1) / 3 commas
            ans += count * ((digits - 1) / 3);

            start *= 10;
            digits++;
        }

        return ans;
    }
}