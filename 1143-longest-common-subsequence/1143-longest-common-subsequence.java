class Solution {
    String s;
    String t;
    int n;
    int m;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        s = text1;
        t = text2;
        n = s.length();
        m = t.length();
        dp = new int[n+1][m+1];
        for(int i = n-1 ; i>=0 ; i--){
            for(int j = m-1; j>=0 ; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }

    private int f(int i,int j){
        if(i == n || j == m) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) return 1 + f(i+1,j+1);

        return dp[i][j] = Math.max(f(i+1,j),f(i,j+1));
    }
}