class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        int fixedParity = -1;      // parity of elements that cannot be changed
        boolean seenOddSmaller = false; // whether any smaller odd value has appeared

        for (int x : sorted) {
            int parity = x & 1;

            // If there is no smaller odd number, this element's parity is fixed.
            if (!seenOddSmaller) {
                if (fixedParity == -1) {
                    fixedParity = parity;
                } else if (fixedParity != parity) {
                    return false;
                }
            }

            // Current odd value becomes a smaller odd for later elements.
            if (parity == 1) {
                seenOddSmaller = true;
            }
        }

        return true;
    }
}