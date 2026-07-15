class Solution {
    Boolean[][] dp;
    Set<String> set;
    int n;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        n = s.length();

        dp = new Boolean[n][n+1];
        set = new HashSet<>(wordDict);

        return f(0,n);
    }

    private boolean f(int i,int j){
        if(set.contains(s.substring(i,j))) return true;
        if(dp[i][j] != null) return dp[i][j];
        boolean ans = false;
        for(int k = i+1; k<j ; k++){
            String sub = s.substring(i,k);
            if(!set.contains(sub)) continue;
            ans |= f(k,j);
        }

        return dp[i][j] = ans;

    }
}