class Solution {
    public long minArraySum(int[] nums) {

        int MAX = 100000;

        boolean[] present = new boolean[MAX + 1];

        for (int num : nums) {
            present[num] = true;
        }

        int[] smallestDivisor = new int[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            smallestDivisor[i] = i;
        }

        // For every value present in the array,
        // update all of its multiples.
        for (int d = 1; d <= MAX; d++) {

            if (!present[d]) continue;

            for (int multiple = d; multiple <= MAX; multiple += d) {
                smallestDivisor[multiple] =
                        Math.min(smallestDivisor[multiple], d);
            }
        }

        long sum = 0;

        for (int num : nums) {
            sum += smallestDivisor[num];
        }

        return sum;
    }
}