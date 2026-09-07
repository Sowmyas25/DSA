class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift the result left to make room for the next bit
            result <<= 1;
            // Extract the rightmost bit of n and add it to result
            result |= (n & 1);
            // Logically shift n to the right by 1 to process the next bit
            n >>>= 1; 
        }
        return result;
    }
}