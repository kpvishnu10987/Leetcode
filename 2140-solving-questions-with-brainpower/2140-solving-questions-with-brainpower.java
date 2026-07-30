class Solution {
    long[] dp;
    int arr[][];
    public long mostPoints(int[][] arr) {
        this.arr = arr;
        int n = arr.length;
        dp = new long[n];
        Arrays.fill(dp,-1);

        return f(0);
    }
    private long f(int i){
        if(i >= arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        long ans = 0;

        long solve = arr[i][0] + f(i+1+arr[i][1]);
        long skip = f(i+1);
        return dp[i] = Math.max(solve,skip);
    }
}