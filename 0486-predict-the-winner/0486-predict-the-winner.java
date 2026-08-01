class Solution {
    int[][] dp;
    int[] nums;
    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        int n = nums.length;

        dp = new int[n][n];

        for(int[] r: dp){
            Arrays.fill(r,-1);
        }

        return f(0,n-1) >=0;
    }

    private int f(int i,int j){
        if(i == j) return nums[i];

        if(dp[i][j] != -1) return dp[i][j];

        int left = nums[i] - f(i+1,j);
        int right = nums[j] - f(i,j-1);

        return dp[i][j] = Math.max(left,right);
    }
}