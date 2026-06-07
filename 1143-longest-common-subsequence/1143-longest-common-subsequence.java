class Solution {
    int[][] dp;
    int n;
    int m;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();

        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, text1, text2);
    }

    private int dfs(int i, int j, String s1, String s2) {
        if (i == n || j == m)
            return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, s1, s2);
        } else {
            dp[i][j] = Math.max(dfs(i + 1, j, s1, s2), dfs(i, j + 1, s1, s2));
        }

        return dp[i][j];
    }
}