class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefValue = new long[n];
        int[] prefSum = new int[n];
        int[] prefCnt = new int[n];

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long value = 0;
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            if (d != 0) {
                value = (value * 10 + d) % MOD;
                sum += d;
                cnt++;
            }

            prefValue[i] = value;
            prefSum[i] = sum;
            prefCnt[i] = cnt;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int digitSum = prefSum[r] - (l > 0 ? prefSum[l - 1] : 0);
            int digitCnt = prefCnt[r] - (l > 0 ? prefCnt[l - 1] : 0);

            long x = prefValue[r];

            if (l > 0) {
                x = (x - prefValue[l - 1] * pow10[digitCnt] % MOD + MOD) % MOD;
            }

            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}