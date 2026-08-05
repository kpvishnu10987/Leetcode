class Solution {
    int[] nums;
    int n;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        n = nums.length;
        this.nums = nums;

        int sum = 0;
        for(int num : nums) sum += num;

        if(sum % 2 != 0) return false;

        sum /= 2;

        dp = new Boolean[n][sum+1];

        return f(0,sum);
    }

    private boolean f(int i,int target){
        if(target == 0) return true;
        if(i >= n) return false;
        if(target < 0) return false;

        if(dp[i][target] != null) return dp[i][target];

        boolean t = f(i+1,target-nums[i]);
        boolean nt = f(i+1,target);

        return dp[i][target] = t || nt;
    }
}