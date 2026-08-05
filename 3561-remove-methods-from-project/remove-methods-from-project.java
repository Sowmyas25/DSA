class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] inv : invocations) {
            adj[inv[0]].add(inv[1]);
        }

        // Find all suspicious methods using BFS from k
        boolean[] suspicious = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        suspicious[k] = true;
        q.add(k);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    q.add(v);
                }
            }
        }

        // Check if any non-suspicious method invokes a suspicious one
        boolean removable = true;
        for (int[] inv : invocations) {
            if (!suspicious[inv[0]] && suspicious[inv[1]]) {
                removable = false;
                break;
            }
        }

        // Prepare result list
        List<Integer> result = new ArrayList<>();
        if (!removable) {
            // Cannot remove suspicious methods; return all methods
            for (int i = 0; i < n; i++) result.add(i);
        } else {
            // Return only non-suspicious methods
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) result.add(i);
            }
        }
        return result;
    }
}