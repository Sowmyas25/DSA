class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Step 1: Assign component IDs based on gaps > maxDiff
        int[] comp = new int[n];
        int currComp = 0;
        comp[0] = currComp;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                currComp++;           // start a new component
            }
            comp[i] = currComp;
        }

        // Step 2: Answer queries using component IDs
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = (comp[u] == comp[v]);
        }
        return answer;
    }
}