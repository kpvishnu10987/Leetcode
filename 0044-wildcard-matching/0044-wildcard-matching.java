class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // dp[i][j] = true if s[i:] matches p[j:]
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: both strings are empty
        dp[n][m] = true;

        // If s is empty, pattern must be all '*' to be a match
        for (int j = m - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                dp[n][j] = dp[n][j + 1];
            } else {
                break;
            }
        }

        // Fill the dp table bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);

                if (pc == '*') {
                    // '*' matches zero (dp[i][j+1]) or more (dp[i+1][j])
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                } else if (pc == '?' || sc == pc) {
                    // Match current and move diagonally
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // Characters don't match
                    dp[i][j] = false;
                }
            }
        }

        return dp[0][0]; // Final answer: does full s match full p
    }
}
