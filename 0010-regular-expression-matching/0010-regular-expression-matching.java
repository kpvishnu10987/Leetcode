class Solution {
    String s;
    String p;
    int n;
    int m;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        n = s.length();
        m = p.length();
        dp = new Boolean[n+1][m+1];

        return f(0,0);
    }

    private boolean f(int i,int j){
        if(i == n){
            while(j+1 <m && p.charAt(j+1) == '*'){
                j+=2;
            }
            return j == m;
        }

        if(j == m) return i == n;

        if(dp[i][j] != null) return dp[i][j];
        


        boolean ans = false;
        boolean match = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
        if(j+1 < m && p.charAt(j+1) == '*'){
            ans |= f(i,j+2);
            ans |= match && f(i+1,j);
        }else{
            ans |= match && f(i+1,j+1);
        }

        return dp[i][j] = ans;

        
    }
}