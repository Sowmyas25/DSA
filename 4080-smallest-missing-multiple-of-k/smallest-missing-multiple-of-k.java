class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Set<Integer> numSet = new HashSet<>();
        // for (int num : nums) {
        //     numSet.add(num);
        // }
        
        // int multiple = k;
        
        // // Find the first multiple not in the set
        // while (numSet.contains(multiple)) {
        //     multiple += k;
        // }
        
        // return multiple; 

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Check positive multiples of k in increasing order
        for (int i = 1; ; i++) {
            int multiple = i * k;
            if (!set.contains(multiple)) {
                return multiple;
            }
        }
    }
}