class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: Rob from house 0 to n-2 (exclude last)
        int robFirst = robLinear(nums, 0, n - 2);
        
        // Case 2: Rob from house 1 to n-1 (exclude first)
        int robLast = robLinear(nums, 1, n - 1);
        
        return Math.max(robFirst, robLast);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev = 0;       // dp[i-1]
        int prev2 = 0;      // dp[i-2]

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;
            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
