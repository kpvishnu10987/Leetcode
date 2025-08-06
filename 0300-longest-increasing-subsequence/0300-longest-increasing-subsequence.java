class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return lis(nums,n,0,-1,dp);
    }

    private int lis(int[] nums,int n,int ind,int prev,int[][] dp){
        if(ind == n) return 0;
        if(dp[ind][prev+1] != -1){
            return dp[ind][prev+1];
        }

        int notTake = lis(nums,n,ind+1,prev,dp);
        int take = 0;
        if(prev == -1 || nums[ind] > nums[prev]){
            take = 1+lis(nums,n,ind+1,ind,dp);
        }
        dp[ind][prev+1] = Math.max(take,notTake);
        return dp[ind][prev+1];
    }
}