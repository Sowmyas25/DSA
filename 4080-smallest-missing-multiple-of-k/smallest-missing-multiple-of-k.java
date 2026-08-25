class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int multiple = k;
        
        // Find the first multiple not in the set
        while (numSet.contains(multiple)) {
            multiple += k;
        }
        
        return multiple; 
    }
}