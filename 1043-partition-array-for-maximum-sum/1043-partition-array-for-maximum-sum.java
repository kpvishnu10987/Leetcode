class Solution {
    int[] dp;
    int n;
    int[] arr;
    int k;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        return f(0);
    }

    private int f(int i){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];

        int max = 0;
        int ans = 0;

        for(int j = i ; j<=Math.min(n-1,i+k-1) ; j++){
            max = Math.max(max,arr[j]);
            ans = Math.max(ans,max * (j-i+1) + f(j+1));
        }

        return dp[i] = ans;
    }
}