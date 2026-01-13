class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) != '0') ? 1 :0;
        
        for(int i = 2  ; i<=n ;i++){
            int single = (s.charAt(i-1) != '0')?dp[i-1]:0;
            int doubl = 0;
            int val = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
            if (val >= 10 && val <= 26){
                doubl = dp[i-2];
            }

            dp[i] = single+doubl;
        }

        return dp[n]>0?dp[n]:0;
        
    }
}