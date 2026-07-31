class Solution {
    public int minimumPushes(String word) {
        // int[] freq = new int[26];
        // for (char c : word.toCharArray()) {
        //     freq[c - 'a']++;
        // }

        // // Collect non‑zero frequencies and sort descending
        // List<Integer> counts = new ArrayList<>();
        // for (int f : freq) {
        //     if (f > 0) counts.add(f);
        // }
        // Collections.sort(counts, Collections.reverseOrder());

        // int pushes = 0;
        // for (int i = 0; i < counts.size(); i++) {
        //     int position = i / 8 + 1;        
        //     pushes += counts.get(i) * position;
        // }
        // return pushes;

        int ans=0;
        int[] fre=new int[26];
        int n=word.length();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            fre[ch-'a']++;
        }
        Arrays.sort(fre);
        for(int i=25;i>=0;i--){
            ans+=fre[i]*((25-i)/8+1);
        }
        return ans;
    }
}