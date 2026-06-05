class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int count = 0;

        for(int len = 1 ; len <= n ; len++){
            for(int i = 0 ; i<= n-len ; i++){
                int j = i+len-1;

                if(len == 1){
                    count++;
                    dp[i][j] = true;
                }
                if(len == 2 && s.charAt(i) == s.charAt(j)){
                    count++;
                    dp[i][j] = true;
                }
                if(len > 2 && dp[i+1][j-1]){
                    if(s.charAt(i) == s.charAt(j)){
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return count;
    }

   
}