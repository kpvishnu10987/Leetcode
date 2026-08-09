class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        return solve(0, 1);
    }

    int solve(int i, int M) {

        // Can take everything remaining
        if (i >= n)
            return 0;

        if (2 * M >= n - i)
            return suffix[i];

        if (dp[i][M] != 0)
            return dp[i][M];

        int bestOpponent = Integer.MAX_VALUE;

        for (int X = 1; X <= 2 * M; X++) {

            int nextM = Math.max(M, X);

            int opponent = solve(i + X, nextM);

            bestOpponent = Math.min(
                bestOpponent,
                opponent
            );
        }

        dp[i][M] = suffix[i] - bestOpponent;

        return dp[i][M];
    }
}