class Solution {
    private static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
            int n = s.length();

            List<Integer> indexList = new ArrayList<>();
            List<Integer> digitList = new ArrayList<>();

            // Store only non-zero digits and their original indices
            for (int i = 0; i < n; i++) {
                int d = s.charAt(i) - '0';
                if (d != 0) {
                    indexList.add(i);
                    digitList.add(d);
                }
            }

            int k = digitList.size();

            int[] indices = new int[k];
            long[] prefixHash = new long[k + 1];
            long[] prefixSum = new long[k + 1];
            long[] pow10 = new long[k + 1];

            for (int i = 0; i < k; i++) {
                indices[i] = indexList.get(i);
            }

            pow10[0] = 1;
            for (int i = 1; i <= k; i++) {
                pow10[i] = (pow10[i - 1] * 10) % MOD;
            }

            for (int i = 1; i <= k; i++) {
                int d = digitList.get(i - 1);
                prefixHash[i] = (prefixHash[i - 1] * 10 + d) % MOD;
                prefixSum[i] = prefixSum[i - 1] + d;
            }

            int[] ans = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0];
                int r = queries[i][1];

                int left = lowerBound(indices, l);
                int right = upperBound(indices, r) - 1;

                if (left > right) {
                    ans[i] = 0;
                    continue;
                }

                long sum = prefixSum[right + 1] - prefixSum[left];

                int len = right - left + 1;

                long x = (prefixHash[right + 1]
                        - (prefixHash[left] * pow10[len]) % MOD
                        + MOD) % MOD;

                ans[i] = (int) ((x * sum) % MOD);
            }

            return ans;
        }

        // First index >= target
        private int lowerBound(int[] arr, int target) {
            int lo = 0, hi = arr.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] >= target)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            return lo;
        }

        // First index > target
        private int upperBound(int[] arr, int target) {
            int lo = 0, hi = arr.length;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] > target)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            return lo;
        }

}