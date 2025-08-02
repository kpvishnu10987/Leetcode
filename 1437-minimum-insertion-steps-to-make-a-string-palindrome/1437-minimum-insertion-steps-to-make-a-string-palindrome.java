class Solution {
    public int minInsertions(String s) {
        int totallength = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int x = lcs(s,s2);
        return totallength-x;
    }
    private int lcs(String s1,String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0 ; i<n ; i++){
            dp[i][0] = 0;
        }

        for(int j = 0 ; j<m ; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i<= n ; i++){
            for(int j = 1; j<= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}