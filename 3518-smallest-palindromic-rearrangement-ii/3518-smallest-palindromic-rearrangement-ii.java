class Solution {
    private static final int LIMIT = 1_000_001;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int[] half = new int[26];
        String mid = "";

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1)
                mid = String.valueOf((char) ('a' + i));
        }

        if (countWays(half) < k)
            return "";

        StringBuilder left = new StringBuilder();
        int len = s.length() / 2;

        for (int pos = 0; pos < len; pos++) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                int ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private int countWays(int[] cnt) {

        int total = 0;
        for (int x : cnt)
            total += x;

        long res = 1;

        int remain = total;

        for (int x : cnt) {

            if (x == 0)
                continue;

            res *= nCr(remain, x);

            if (res >= LIMIT)
                return LIMIT;

            remain -= x;
        }

        return (int) res;
    }

    private long nCr(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - i + 1) / i;

            if (ans >= LIMIT)
                return LIMIT;
        }

        return ans;
    }
}