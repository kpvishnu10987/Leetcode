class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n <= 1) return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0],nums[1]);
        for(int i = 2; i<n ;i++){
            int rob = nums[i] + prev2;
            int skip = prev1;
            int cur = Math.max(rob,skip);
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}