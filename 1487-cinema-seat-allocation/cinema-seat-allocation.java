class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Store reserved seat bitmask for each row that has reservations
        Map<Integer, Integer> rows = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            rows.put(row, rows.getOrDefault(row, 0) | (1 << (col - 1)));
        }

        int ans = (n - rows.size()) * 2; // rows with no reservations can fit 2 groups

        // Seat blocks (1-indexed seats):
        // left   = seats 2,3,4,5
        // middle = seats 4,5,6,7
        // right  = seats 6,7,8,9
        int leftMask   = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4);
        int middleMask = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6);
        int rightMask  = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8);

        for (int mask : rows.values()) {
            boolean left = (mask & leftMask) == 0;
            boolean middle = (mask & middleMask) == 0;
            boolean right = (mask & rightMask) == 0;

            if (left && right) {
                ans += 2;               // two non-overlapping groups
            } else if (left || middle || right) {
                ans += 1;               // only one group is possible
            }
        }

        return ans;
    }
}