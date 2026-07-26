class Solution {
    public int maximumProduct(int[] nums) {
        // Arrays.sort(nums);
        // return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[nums.length - 1] * nums[1] * nums[0]) ;

        int l = nums.length;
        int ma1 = Integer.MIN_VALUE;
        int ma2 = Integer.MIN_VALUE;
        int ma3 = Integer.MIN_VALUE;
        int mi1 = Integer.MAX_VALUE;
        int mi2 = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n > ma1) {
                ma3 = ma2;
                ma2 = ma1;
                ma1 = n;
            } else if (n > ma2) {
                ma3 = ma2;
                ma2 = n;
            } else if (n > ma3) {
                ma3 = n;
            }
            if (n < mi1) {
                mi2 = mi1;
                mi1 = n;
            } else if (n < mi2) {
                mi2 = n;
            }
        }
        return Math.max(Math.max(mi1 * mi2 * ma1, mi1 * ma2 * ma1), ma1 * ma2 * ma3);
    }
}