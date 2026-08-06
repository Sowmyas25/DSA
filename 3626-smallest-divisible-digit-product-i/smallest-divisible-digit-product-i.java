class Solution {
    public int smallestNumber(int n, int t) {
    int num = n;
        while (true) {
            int product = 1;
            int tmp = num;
            while (tmp > 0) {
                product *= (tmp % 10);
                tmp /= 10;
            }
            if (product % t == 0) {
                return num;
            }
            num++;
        }
    }
}