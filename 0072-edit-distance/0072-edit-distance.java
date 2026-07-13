class Solution {
    String w1;
    String w2;
    int n;
    int m;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        w1 = word1;
        w2 = word2;
        n = w1.length();
        m = w2.length();
        dp = new int[n][m];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }

        return dfs(0,0);
    }

    private int dfs(int i,int j){
        if(j == m){
            if(i == n){
                return 0;
            }else{
                return n-i;
            }
        }
        if(i == n) return m-j;

        if(dp[i][j] != -1) return dp[i][j];



        if(w1.charAt(i) == w2.charAt(j)) return dp[i][j] = dfs(i+1,j+1);

        int ins = dfs(i,j+1);
        int del = dfs(i+1,j);
        int rep = dfs(i+1,j+1);

        return dp[i][j] =  1 + Math.min(ins,Math.min(del,rep));
    }
}