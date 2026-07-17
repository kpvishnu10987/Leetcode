class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        // frequency of each value
        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // cnt[d] = how many numbers are divisible by d
        long[] cnt = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                cnt[d] += freq[multiple];
            }
        }

        // exact[d] = number of pairs whose gcd is exactly d
        long[] exact = new long[max + 1];

        for (int d = max; d >= 1; d--) {
            long pairs = cnt[d] * (cnt[d] - 1) / 2;

            for (int multiple = d * 2; multiple <= max; multiple += d) {
                pairs -= exact[multiple];
            }

            exact[d] = pairs;
        }

        // prefix counts
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; // kth (1-indexed)

            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (prefix[mid] >= target)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans[i] = lo;
        }

        return ans;
    }
}