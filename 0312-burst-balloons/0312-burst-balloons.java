class Solution {
    int[] arr;
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = n+2;

        arr = new int[m];
        arr[0] = 1;
        arr[n+1] = 1;
        dp = new int[m][m];

        for(int i = 0 ; i<n ; i++){
            arr[i+1] = nums[i];
        }

        for(int[] r: dp) Arrays.fill(r,-1);

        return f(0,n+1);
        
    }
    private int f(int i,int j){
        if(j == i+1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        for(int k = i+1; k<j ; k++){
            int cost = arr[i] * arr[k] * arr[j] + f(i,k) + f(k,j);
            ans = Math.max(cost,ans);
        }

        return dp[i][j] = ans;
    }
}