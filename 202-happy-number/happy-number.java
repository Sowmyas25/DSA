class Solution {
    public boolean isHappy(int n) {
    //     Set<Integer> seen = new HashSet<>();
        
    //     // Loop until n becomes 1 or we find a cycle
    //     while (n != 1 && !seen.contains(n)) {
    //         seen.add(n);
    //         n = getNext(n);
    //     }
        
    //     return n == 1;
    // }

    // private int getNext(int num) {
    //     int totalSum = 0;
    //     while (num > 0) {
    //         int digit = num % 10;
    //         totalSum += digit * digit;
    //         num /= 10;
    //     }
    //     return totalSum;

     while(n!=1 && n!=4){
            int sum = 0;
            while(n>0){
                int digit = n %10;
                sum += digit * digit;
                n /=10;
            }
            n = sum;
        }
        return n == 1; 
    }
}