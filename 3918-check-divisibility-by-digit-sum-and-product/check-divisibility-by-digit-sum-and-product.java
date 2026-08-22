class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int prod = 1;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            prod = prod * rem;
            sum = sum + rem;
            n = n / 10;
        }

        if (num % (sum + prod) == 0) return true;
        else return false;
    }
}