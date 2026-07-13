class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int start = 1; start <= 9; start++) {
            int num = start;
            int nextDigit = start;
            while (num <= high && nextDigit < 9) {
                if (num >= low) {
                    result.add(num);
                }
                nextDigit++;
                num = num * 10 + nextDigit;
            }

            if (num >= low && num <= high) {
                result.add(num);
            }
        }
        Collections.sort(result);
        return result;
    }
}
