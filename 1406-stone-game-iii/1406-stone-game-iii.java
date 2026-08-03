class Solution {
    int[] dp;
    int[] arr;
    int n;
    public String stoneGameIII(int[] arr) {
        this.arr = arr;
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        int ans = f(0);

        if(ans == 0) return "Tie";

        return ans > 0 ? "Alice" : "Bob";
    }
    private int f(int i){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];

        int one = arr[i] - f(i+1);

        int two = Integer.MIN_VALUE;
        if(i+1 < n){
            two = arr[i] + arr[i+1] - f(i+2);
        }
        int three = Integer.MIN_VALUE;
        if(i+2 < n){
            three = arr[i] + arr[i+1] + arr[i+2] -f(i+3);
        }

        return dp[i] = Math.max(one,Math.max(two,three));
    }
}