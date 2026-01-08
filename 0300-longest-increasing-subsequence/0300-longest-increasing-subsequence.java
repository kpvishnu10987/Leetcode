class Solution {
    int dp[];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];

        Arrays.fill(dp,-1);

        int ans = 1;

        for(int i = 0 ;i<n ;i++){
            ans = Math.max(ans,solve(i,nums));
        }

        return ans;    
    }

    private int solve(int i, int[] nums){
        if(dp[i] != -1) return dp[i];

        int best = 1;
        for(int j = 0 ; j<i ; j++){
            if(nums[i] > nums[j]){
                best = Math.max(best,1+solve(j,nums));
            }
        }
        return dp[i] = best;
    }
}