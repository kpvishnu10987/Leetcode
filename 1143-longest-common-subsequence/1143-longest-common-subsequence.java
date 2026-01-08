class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        // base case: first cell
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }

        // first row
        for (int j = 1; j < m; j++) {
            if (text1.charAt(0) == text2.charAt(j))
                dp[0][j] = 1;
            else
                dp[0][j] = dp[0][j - 1];
        }

        // first column
        for (int i = 1; i < n; i++) {
            if (text1.charAt(i) == text2.charAt(0))
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i - 1][0];
        }

        // rest of DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
