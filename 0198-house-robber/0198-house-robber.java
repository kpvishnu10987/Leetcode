class Solution {
    int[] nums;
    int[] dp;
    int n;
    public int rob(int[] nums) {
        this.nums = nums;
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        return f(0);
    }

    private int f(int i){
        if(i >= n) return 0;

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + f(i+2);
        int skip = f(i+1);

        return dp[i] = Math.max(take,skip); 
    }

}