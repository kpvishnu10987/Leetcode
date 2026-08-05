class Solution {
    Set<String> set ;
    int n;
    String s;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        n = s.length();
        set = new HashSet<>(wordDict);
        dp  = new Boolean[n];


        return f(0);
    }

    private boolean f(int l){
        if(l > n) return false;
        if(set.contains(s.substring(l,n))) return true;

        if(dp[l] != null) return dp[l];

        boolean ans  = false;

        for(int i = l ; i<n ; i++){
            if(set.contains(s.substring(l,i+1))){
                ans |= f(i+1);
            }
        }

        return dp[l] = ans;
    }
}