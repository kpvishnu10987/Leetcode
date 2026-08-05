class Solution {
    int n;
    int max;
    int nums[];
    int target;
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        n = nums.length;
        this.target = target;
        for(int num : nums){
            max += num;
        }

        dp = new int[n][2*max+1];

        for(int[] r : dp) Arrays.fill(r,-1);

        return f(0,0);
    }

    private int f(int i,int total){
        if(i == n){
            if(total == target){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[i][max + total] != -1) return dp[i][max+total];

        int pos = f(i+1,total + nums[i]);
        int neg = f(i+1,total - nums[i]);

        return dp[i][max+total] = pos + neg;
    }
}