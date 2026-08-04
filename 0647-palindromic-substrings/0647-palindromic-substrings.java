class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int ans = 0;
        boolean[][] dp = new boolean[n][n];

        for(int len =  1; len <= n ; len++){
            for(int i = 0 ; i+len-1 < n ; i++){
                int j = i + len -1;

                if(len == 1){
                    dp[i][j] = true;
                }else if(len == 2){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }

                if(dp[i][j]) ans++;
            }
        }

        return ans;
    }
}