class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int maxi = nums[0];
        int sum = nums[0];
        for(int i = 1; i<n ; i++){
            sum  = Math.max(nums[i],sum+nums[i]);
            maxi = Math.max(sum,maxi);
        }
        return maxi;
    }
}