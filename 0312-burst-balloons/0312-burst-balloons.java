class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // Step 1: Create new array with 1 padding on both sides
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }
        
        // Step 2: DP array
        int[][] dp = new int[n + 2][n + 2];
        
        // Step 3: Iterate over lengths of subarrays
        for (int len = 2; len < n + 2; len++) { // len is the distance between l and r
            for (int left = 0; left < n + 2 - len; left++) {
                int right = left + len;
                // Step 4: Try every balloon as the last burst in (left, right)
                for (int k = left + 1; k < right; k++) {
                    int coins = balloons[left] * balloons[k] * balloons[right];
                    coins += dp[left][k] + dp[k][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        
        // Step 5: Result for bursting all balloons between 0 and n+1
        return dp[0][n + 1];
    }
}
