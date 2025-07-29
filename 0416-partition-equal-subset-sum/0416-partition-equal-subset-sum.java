class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int total = 0;
        for(int num : nums){
            total += num;
        }
        int target = total/2;

        if(total%2 != 0) return false; 


        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num : nums){
            for(int i = target ; i>= num ; i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }

        return dp[target];
    }
}