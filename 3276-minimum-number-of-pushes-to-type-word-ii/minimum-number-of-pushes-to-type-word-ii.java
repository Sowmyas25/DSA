class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Collect non‑zero frequencies and sort descending
        List<Integer> counts = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) counts.add(f);
        }
        Collections.sort(counts, Collections.reverseOrder());

        int pushes = 0;
        for (int i = 0; i < counts.size(); i++) {
            int position = i / 8 + 1;        
            pushes += counts.get(i) * position;
        }
        return pushes;
    }
}