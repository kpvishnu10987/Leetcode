class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totsum = 0;
        for(int x : nums) totsum += x;
        int s1 = totsum + target;
        s1 = s1/2;
        if((totsum+target)%2 != 0 || target > totsum || target < -totsum){
            return 0;
        }
        int dp[] = new int[s1+1];
        dp[0] = 1;

        for(int num : nums){
            for(int sum = s1 ; sum >= num ; sum--){
                
                    dp[sum] += dp[sum-num];
                
            }
        }
        return dp[s1];
    }
}