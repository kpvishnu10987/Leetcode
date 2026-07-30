class Solution {
    int n;
    Boolean[][] dp;
    int[] nums;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        n = nums.length;
      

        int sum = 0;
        for(int i = 0 ; i<n ;i++){
            sum += nums[i];
        }

        if(sum % 2 != 0) return false;

        sum /= 2;
        dp = new Boolean[n][sum+1];

        return f(0,sum);
    }

    private boolean f(int i,int k){
        if(i == n){
            if(k == 0) return true;
            return false;
        }
        if(k < 0) return false;

        if(dp[i][k] != null) return dp[i][k]; 


        boolean ans = false;


        ans |= f(i+1,k-nums[i]);
        ans |= f(i+1,k);

        return dp[i][k] =  ans;
    }
}