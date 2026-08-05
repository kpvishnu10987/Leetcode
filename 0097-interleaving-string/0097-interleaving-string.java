class Solution {
    String s1;
    String s2;
    String s3;
    int n;
    int m;
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        
        n = s1.length();
        m = s2.length();
        if(n + m != s3.length()) return false;

        dp = new Boolean[n][m];

        return f(0,0);
        
    }

    private boolean f(int i,int j){
        if(i == n && j == m) return true;
        if(i == n){
            return s2.substring(j).equals(s3.substring(i+j));
        }
        if(j == m){
            return s1.substring(i).equals(s3.substring(i+j));
        }

        if(dp[i][j] != null) return dp[i][j];

        int a = s1.charAt(i);
        int b = s2.charAt(j);
        int c= s3.charAt(i+j);
        if(a != c && b != c) return dp[i][j] = false;
        boolean ans = false;

        if(a == c){
            ans |= f(i+1,j);
        }
        if(b == c){
            ans |= f(i,j+1);
        }

        return dp[i][j] = ans;
    }
}