class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int maxSoFar = nums[0];
        prefixGcd[0] = nums[0];               // gcd with itself is the number

        for (int i = 1; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxSoFar);
        }

        Arrays.sort(prefixGcd);

        long total = 0;
        // pair smallest with largest, second smallest with second largest, etc.
        for (int i = 0; i < n / 2; i++) {
            total += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
        }
        return total;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}